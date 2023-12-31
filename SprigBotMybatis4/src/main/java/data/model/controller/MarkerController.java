package data.model.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import data.model.dto.MarketDto;
import data.model.mapper.MarketMapperInter;
import data.model.service.MarketServiceInter;

@Controller
public class MarkerController {
	
	/*
	 * @Autowired MarketMapperInter mapper;
	 */
	
	@Autowired
	MarketServiceInter service;
	@GetMapping("/")
	public String start() {
		return "redirect:market/list";
	}
	
	@GetMapping("/market/list")
	public ModelAndView list() {
		ModelAndView model=new ModelAndView();
		
		List<MarketDto>list=service.getAllSangpums();
		
		//db로부터 총개수 얻기
		int totalCount=service.getTotalCountOfMarket();
		
		//저장
		model.addObject("totalCount",totalCount);
		model.addObject("list", list);
		//포워드
		model.setViewName("market/marketlist");
		
		return model;
	}
	
	@GetMapping("/market/writeform")
	public String writeForm() {
		return "market/addForm";
	}
	
	@PostMapping("/market/add")
	public String insert(MarketDto dto,
			HttpSession session,MultipartFile photoupload) {
		
		String path=session.getServletContext().getRealPath("/save");	
		System.out.println(path);
		System.out.println(photoupload.getOriginalFilename());
		
		if(photoupload.getOriginalFilename().equals("")) {
			dto.setPhotoname("no.png");
		}else {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
			String name=sdf.format(new Date())+photoupload.getOriginalFilename();
			dto.setPhotoname(name);
		
			try {
				photoupload.transferTo(new File(path+"\\"+name));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}
		
		service.insertMarket(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("market/updateform")
	public String updateForm(Model model,@RequestParam String num) {
		
		MarketDto dto=service.getDataSangpum(num);
		
		model.addAttribute("dto", dto);
		
		return "market/updateForm";
	}
	
	@PostMapping("market/update")
	public String update(@ModelAttribute MarketDto dto,
			HttpSession session, MultipartFile photoupload) {
		
		String path=session.getServletContext().getRealPath("/save");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		if(photoupload.getOriginalFilename().equals("")) {
			dto.setPhotoname(null);
		}else {
			String name=sdf.format(new Date())+photoupload.getOriginalFilename();
			
			File file=new File(path+"\\"+name);
			file.delete();
			
			try {
				photoupload.transferTo(new File(path+"\\"+name));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dto.setPhotoname(name);
		}
		service.updateMarket(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("market/delete")
	public String delete(@RequestParam String num,HttpSession session) {
		
		String photo=service.getDataSangpum(num).getPhotoname();
		
		if(!photo.equals("no.png")) {
			String path=session.getServletContext().getRealPath("save");
			
			File file=new File(path+"\\"+photo);
			
			file.delete();
		}
		service.deleteMarket(num);
		
		return "redirect:list";
	}

}
