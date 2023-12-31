package data.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.model.dto.MarketDto;

@Mapper
public interface MarketMapperInter {
	
	public int getTotalCountOfMarket(); //getTotalCount가 id 역할을 한다
	public List<MarketDto> getAllSangpums();
	public void insertMarket(MarketDto dto);
	public MarketDto getDataSangpum(String num);
	public void updateMarket(MarketDto dto);
	public void deleteMarket(String num);
}
