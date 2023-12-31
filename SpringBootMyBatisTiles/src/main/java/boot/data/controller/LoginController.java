package boot.data.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	MemberService service;

	@GetMapping("/login/main")
	public String loginform(HttpSession session,
			Model model) {
		//폼에 id 얻어줘야함
		String myid=(String)session.getAttribute("myid");
		//로그인인지 아닌지 판단
		String loginok=(String)session.getAttribute("loginok");
		
		//한번도 실행안하면 null
		if(loginok==null) {
			return "/login/loginForm";
		}
		//로그인 중이면 request에 name 저장
		String name=service.getName(myid);
		model.addAttribute("name", name);
		
		return "/sub/login/logoutForm";
	}
	
	@PostMapping("/login/loginprocess")
	public String loginproc(@RequestParam String id,
			@RequestParam String pass, @RequestParam(required = false) String savechk,
			HttpSession session) {
		HashMap<String, String>map=new HashMap<>();
		int check=service.loginPassCheck(id, pass);
		if(check==1) {
			session.setMaxInactiveInterval(60*60*8);
			session.setAttribute("myid", id);
			session.setAttribute("loginok", "ok");
			session.setAttribute("saveok", savechk);
			
			MemberDto mdto=service.getDataById(id);
			session.setAttribute("loginphoto", mdto.getPhoto());
			session.setAttribute("loginname", mdto.getName());
			
			return "redirect:main";
		}
		
		return "/member/passFail";
	}
	
	@GetMapping("login/logoutprocess")
	public String logout(HttpSession session) {
		session.removeAttribute("loginok");
		session.removeAttribute("loginphoto");
		session.removeAttribute("loginame");
		
		return "redirect:main";
	}
	
	
}
