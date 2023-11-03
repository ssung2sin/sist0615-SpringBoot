package boot.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import boot.data.dto.MbAnswerDto;

@Mapper
public interface MbAnswerMapperInter {

	public void insertMbAnswer(@RequestParam MbAnswerDto dto);
	public List<MbAnswerDto> getAllAnswers(String num);
	public MbAnswerDto getAnswer(String idx);
	public void updateMbAnswer(@RequestParam MbAnswerDto dto);
	public void deleteMbAnswer(@RequestParam String idx);
}
