package boot.data.service;

import boot.data.dto.ReboardDto;
import java.util.List;

public interface ReboardServiceInter {
    public int getMaxNum();

    public int getTotalCount(String searchcolumn, String searchword);

    public List<ReboardDto> getPagingList(String searchcolumn, String searchword,
                                          int startnum, int perpage);

    public void insertReboard(ReboardDto dto);

    public void updateRestep(int regroup, int restep);

    public void updateReadCount(String num);

    public ReboardDto getData(int num);

    public void updateReboard(ReboardDto dto);

    public void deleteReboard(int num);

    public void updateLickes(int num);
}
