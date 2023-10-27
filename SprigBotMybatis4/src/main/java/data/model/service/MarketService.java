package data.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.model.dto.MarketDto;
import data.model.mapper.MarketMapperInter;

@Service
public class MarketService implements MarketServiceInter {
	
	@Autowired
	MarketMapperInter mapperInter;

	@Override
	public int getTotalCountOfMarket() {
		// TODO Auto-generated method stub
		return mapperInter.getTotalCountOfMarket();
	}

	@Override
	public List<MarketDto> getAllSangpums() {
		// TODO Auto-generated method stub
		return mapperInter.getAllSangpums();
	}

	@Override
	public void insertMarket(MarketDto dto) {
		// TODO Auto-generated method stub
		mapperInter.insertMarket(dto);
		
	}

	@Override
	public MarketDto getDataSangpum(String num) {
		// TODO Auto-generated method stub
		return mapperInter.getDataSangpum(num);
	}

	@Override
	public void updateMarket(MarketDto dto) {
		// TODO Auto-generated method stub
		mapperInter.updateMarket(dto);
	}

	@Override
	public void deleteMarket(String num) {
		// TODO Auto-generated method stub
		mapperInter.deleteMarket(num);
	}

}