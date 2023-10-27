package boot.mvc.ex1;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
@Data // 세터게터 투스트링 다 받는거랑 같음
public class TestDto {
	
	private String name;
	private String addr;
	
}
