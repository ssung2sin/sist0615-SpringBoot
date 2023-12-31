package data.model.service;

import java.util.List;

import data.model.dto.MarketDto;

public interface MarketServiceInter {
	public int getTotalCountOfMarket(); //getTotalCount가 id 역할을 한다
	public List<MarketDto> getAllSangpums();
	public void insertMarket(MarketDto dto);
	public MarketDto getDataSangpum(String num);
	public void updateMarket(MarketDto dto);
	public void deleteMarket(String num);
}
