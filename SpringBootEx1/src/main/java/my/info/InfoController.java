package my.info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InfoController {
	
	@GetMapping("/my/info")
	@ResponseBody
	public Map<String, String> info(){
		
		Map<String,String> map=new HashMap<>();
		
		map.put("name", "이성신");
		map.put("age", "28");
		map.put("addr", "경기도시흥시");
		
		return map;
	}
}
