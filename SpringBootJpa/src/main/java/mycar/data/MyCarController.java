package mycar.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/car")
public class MyCarController {
	
	@Autowired
	MyCarDao dao;
	
	@GetMapping("/carlist")
	public String list(Model model) {
		
		List<MyCarDto> list=dao.getAllDatas();
		
		model.addAttribute("list",list);
		model.addAttribute("totalCount",list.size());
		
		return "carList";
	}
	
	@GetMapping("/carform")
	public String form() {
		
		return "addForm";
	}
	
	@PostMapping("/insert")
	public String insert(Model model, @ModelAttribute("dto") MyCarDto dto,
			MultipartFile carupload,HttpSession session) {
		
		//업로드할 save 위치 구하기
		String path=session.getServletContext().getRealPath("/save");
		
		//업로드할 파일 dto 얻기
		dto.setCarphoto(carupload.getOriginalFilename());
		
		//실제 업로드
		try {
			carupload.transferTo(new File(path+"\\"+carupload.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dao.insertMyCar(dto);
		
		return "redirect:carlist";
	}
	
	@GetMapping("/updateform")
	public String updateForm(Model model,@RequestParam Long num) {
		MyCarDto dto=dao.getData(num);
		model.addAttribute("dto", dto);
		
		return "uForm";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute("dto")MyCarDto dto) {
		
		dao.updateMyCar(dto);
		return "redirect:carlist";
	}
	@GetMapping("/delete")
	public String update(@RequestParam Long num) {
		dao.deleteMyCar(num);
		return "redirect:carlist";
	}
	
	@GetMapping("detail")
	public String detail(Long num,Model model) {
		
		MyCarDto dto=dao.getData(num);
		model.addAttribute("dto",dto);
		
		return "detail";
	}
}
