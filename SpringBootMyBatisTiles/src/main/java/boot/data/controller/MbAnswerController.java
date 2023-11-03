package boot.data.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boot.data.dto.MbAnswerDto;
import boot.data.mapper.MbAnswerMapperInter;
import boot.data.service.MemberService;

@RestController
@RequestMapping("/mbanswer")
public class MbAnswerController {
	
	@Autowired
	MbAnswerMapperInter mapper;
	
	@Autowired
	MemberService mservice;
	
	@PostMapping("/ainsert")
	public void insert(@ModelAttribute MbAnswerDto dto,HttpSession session) {
		
		String id=(String)session.getAttribute("myid");
		String name=mservice.getDataById(id).getName();
		
		dto.setMyid(id);
		dto.setName(name);
		
		mapper.insertMbAnswer(dto);
	}
	
	@GetMapping("/alist")
	public List<MbAnswerDto> list(@RequestParam String num) {
		
		List<MbAnswerDto>list= mapper.getAllAnswers(num);
		
		return list;
	}
	
	@GetMapping("/adelete")
	public void delete(String idx) {
		
		mapper.deleteMbAnswer(idx);
	}

	//수정창 content띄우기
	@GetMapping("/adata")
    public MbAnswerDto getData(String idx) {

		return mapper.getAnswer(idx);
	}


	//실질적인 수정
	@PostMapping("/aupdate")
	public void aupdate(@ModelAttribute MbAnswerDto dto) {

		mapper.updateMbAnswer(dto);
	}
}
