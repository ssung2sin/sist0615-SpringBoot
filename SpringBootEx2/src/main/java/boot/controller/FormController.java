package boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.dto.PersonDto;

@Controller
public class FormController {
	
	@GetMapping("/sist/home")
	public String home() {
		
		return "home";
	}
	
	@GetMapping("sist/form1")
	public String form1() {
		
		return "form/form1";
	}
	@PostMapping("sist/read1")
	public String read1(Model model,@RequestParam String irum,
			@RequestParam int java, @RequestParam int spring) { //스트링으로 받든 인트로 받든 가능!
		
		model.addAttribute("irum", irum);
		model.addAttribute("java", java);
		model.addAttribute("spring",spring);
		
		return "result/result1";
	}
	
	@GetMapping("sist/form2")
	public String form2() {
		
		return "form/form2";
	}
	
	@PostMapping("sist/read2")
	public String read2(@ModelAttribute("dto") PersonDto dto) {	//여기에 ("dto")하지 않으면 personDto로 받아야함
		
		return "result/result2";
	}
	
	@GetMapping("sist/form3")
	public String form3() {
		
		return "form/form3";
	}
	@PostMapping("sist/myread")
	public String read3(Model model,@RequestParam Map<String, String>map) {
		
		model.addAttribute("name", map.get("name"));
		model.addAttribute("blood", map.get("blood"));
		model.addAttribute("age",map.get("age"));
		
		model.addAttribute("map",map);
		
		return "result/result3";
	}
}
