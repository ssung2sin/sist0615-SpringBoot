package boot.data.service;

import java.util.HashMap;
import java.util.List;

import boot.data.dto.MemBoardDto;
import boot.data.dto.MemberDto;

public interface MemBoardServiceInter {
	
	public int getTotalCount();
	public void updateReadCount(String num);
	public void insertMemBoard(MemBoardDto dto);
	public MemBoardDto getData(String num);
	public int getMaxNum();
	public List<MemBoardDto> getList(int start,int perPage);
}
