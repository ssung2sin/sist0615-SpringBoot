package boot.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import boot.data.service.MemBoardService;

@Controller
public class ReboardController {
	
	@Autowired
	MemBoardService service;

	@GetMapping("/reboard/list")
	public String boardlist() {
		
		return "/reboard/boardList";
	}
}
