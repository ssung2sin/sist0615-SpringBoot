package boot.data.mapper;

import boot.data.dto.MbAnswerDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface SmartMapperInter {
    public void insertSmartShop(@RequestParam MbAnswerDto dto);
    public List<MbAnswerDto> getAllSangpums(int num);
    public MbAnswerDto getSmartSangpum(int num);
    public void updateSmartShop(@RequestParam MbAnswerDto dto);
    public void deleteSmartShop(@RequestParam int num);
}
