package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/member/myinfo")
	public String info(Model model) {
		
		List<MemberDto>list=service.getAllMembers();
		
		model.addAttribute("list", list);
		return "/member/myinfo";
	}
	
	@GetMapping("/member/list")
	public String listForm(Model model) {
		List<MemberDto> list=service.getAllMembers();
		
		model.addAttribute("list", list);
		model.addAttribute("totalCount", list.size());
		return "/member/memberList";
	}
	
	@GetMapping("member/form")
	public String addForm() {
		
		return "/member/addForm";
	}
	
	@ResponseBody
	@GetMapping("/member/check")
	public Map<String, Integer> check(String id) {
		
		Map<String, Integer>returnMap=new HashMap<>();
		int count=service.getSearchId(id);
		
		returnMap.put("count", count);
		
		return returnMap;
	}
	
	//insert (일단은 list로 가는데 admin이 아니면 gaipsucess로 이동할 예정)
	@PostMapping("/member/insert")
	public String insertMember(@ModelAttribute MemberDto dto,
			MultipartFile myphoto, HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/membersave");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String name=sdf.format(new Date())+"_"+myphoto.getOriginalFilename();
		
		try {
			myphoto.transferTo(new File(path+"\\"+name));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dto.setPhoto(name);
		
		service.insertMember(dto);
		
		return "redirect:list";
	}
}
