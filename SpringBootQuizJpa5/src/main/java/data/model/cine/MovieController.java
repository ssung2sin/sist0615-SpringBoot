package data.model.cine;

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

@Controller
public class MovieController {

	@Autowired
	MovieDao dao;
	
	@GetMapping("/")
	public String start() {
		return "redirect:movie/list";
	}
	
	@GetMapping("/movie/list")
	public String list(Model model) {
		List<MovieDto>list=dao.getAllMovies();
		
		model.addAttribute("list", list);
		model.addAttribute("totalCount",dao.getCountMovies());
		return "movie/movieList";
	}
	
	@GetMapping("/movie/addform")
	public String addForm() {
		
		return "movie/addForm";
	}
	@PostMapping("/movie/add")
	public String add(Model model,@ModelAttribute MovieDto dto,
			HttpSession session,MultipartFile posterUpload) {
		
		String path=session.getServletContext().getRealPath("/moviephoto");
		String name=posterUpload.getOriginalFilename();
		
		try {
			posterUpload.transferTo(new File(path+"\\"+name));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setMv_poster(name);
		
		dao.insertMovie(dto);
		
		
		return "redirect:list";
	}
	
	@GetMapping("movie/detail")
	public String detail(Model model,@RequestParam Long mv_num) {
		MovieDto dto=dao.getMovie(mv_num);
		
		model.addAttribute("dto", dto);
		return "movie/detail";
	}
}
