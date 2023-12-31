package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import boot.data.dto.IpgoDto;
import boot.data.mapper.IpgoMapperInter;

@Controller
public class IpgoController {

	@Autowired
	IpgoMapperInter mapper;
	
	@GetMapping("/")
	public String start() {
		return "/layout/main";
	}
	
	@GetMapping("/ipgo/list")
	public String list(Model model) {
		
		int totalCount=mapper.getTotalCount();
		List<IpgoDto>list=mapper.getAllIpgos();
		
		model.addAttribute("list", list);
		model.addAttribute("totalCount", totalCount);
		
		/* return "ipgoList";  jsp 리졸버였음 이제 tiles 리졸버여야함*/
		return "/ipgo/ipgoList"; /* tiles 경로로 고치기*/
	}
	
	@GetMapping("ipgo/ipgoform")
	public String ipgoForm() {
		
		return "/ipgo/ipgoForm";
	}
	
	@PostMapping("ipgo/insert")
	public String insert(@ModelAttribute IpgoDto dto,
			@RequestParam ArrayList<MultipartFile> photoupload,
			HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/upload");
		System.out.println(path);
		
		String uploadName="";
		
		if(photoupload.get(0).getOriginalFilename().equals("")) {
			uploadName="no";
		}else {
			for(int i=0;i<photoupload.size();i++) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
				String fName=sdf.format(new Date())+"_"+photoupload.get(i).getOriginalFilename();
				uploadName+=fName+",";
				
				try {
					photoupload.get(i).transferTo(new File(path+"\\"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//photo 마지막 콤마 제거
			uploadName=uploadName.substring(0, uploadName.length()-1);
		}
		dto.setPhotoname(uploadName);
		
		mapper.insertIpgo(dto);
		
		return "redirect:list";
	}
}
