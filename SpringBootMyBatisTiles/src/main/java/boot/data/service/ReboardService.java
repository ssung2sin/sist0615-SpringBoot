package boot.data.service;

import boot.data.dto.ReboardDto;
import boot.data.mapper.ReboardMapperInter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReboardService implements ReboardServiceInter {

    @Autowired
    ReboardMapperInter mapperInter;

    @Override
    public int getMaxNum() {
        return mapperInter.getMaxNum();
    }

    @Override
    public int getTotalCount(String searchcolumn, String searchword) {

        Map<String, String> map = new HashMap<>();
        map.put("searchcolumn", searchcolumn);
        map.put("searchword", searchword);

        return mapperInter.getTotalCount(map);
    }

    @Override
    public List<ReboardDto> getPagingList(String searchcolumn, String searchword, int startnum, int perpage) {

        Map<String, Object> map = new HashMap<>();
        map.put("searchcolumn", searchcolumn);
        map.put("searchword", searchword);
        map.put("startnum", startnum);
        map.put("perpage", perpage);

        return mapperInter.getPagingList(map);
    }

    @Override
    public void insertReboard(ReboardDto dto) {
        int num = dto.getNum();
        int regroup = dto.getRegroup();
        int restep = dto.getRestep();
        int relevel = dto.getRelevel();

        if (num == 0) {
            regroup = this.getMaxNum() + 1;
            restep = 0;
            relevel = 0;
        } else { //답글일경우
            //같은 그룹중 전달받은 restep보다 큰 값들은 모두 일괄적으로 +1이 된다
            this.updateRestep(regroup, restep);
            //그리고 나서 전달받은 갑보다 1크게 db에 저장
            restep++;
            relevel++;
        }
        dto.setRegroup(regroup);
        dto.setRestep(restep);
        dto.setRelevel(relevel);

        mapperInter.insertReboard(dto);
    }

    @Override
    public void updateRestep(int regroup, int restep) {
        Map<String, Integer> map = new HashMap<>();
        map.put("regroup", regroup);
        map.put("restep", restep);

        mapperInter.updateRestep(map);
    }

    @Override
    public void updateReadCount(int num) {
        mapperInter.updateReadCount(num);
    }

    @Override
    public ReboardDto getData(int num) {
        return mapperInter.getData(num);
    }

    @Override
    public void updateReboard(ReboardDto dto) {
        mapperInter.updateReboard(dto);
    }

    @Override
    public void deleteReboard(int num) {
        mapperInter.deleteReboard(num);
    }

    @Override
    public void updateLikes(int num) {
        mapperInter.updateLikes(num);
    }
}
