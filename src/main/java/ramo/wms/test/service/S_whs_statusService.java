package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.S_whs_statusMapper;
import ramo.wms.test.domain.S_whs_status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class S_whs_statusService {
    @Autowired(required = false)
    private S_whs_statusMapper mapper;

    public List<S_whs_status> all(){
        List<S_whs_status> List= mapper.all();
        return List;
    }

    //根据仓位ID查找
    public S_whs_status findByid(String id){
        S_whs_status one= mapper.findById(id);
        return one;
    }

    //查找所有没有被上仓位锁的仓位,并返回whs_id(仓位),whs_infoid（仓位说明）,whs_allvol（仓位总容积）,whs_availvol（当前可以容积）,percent（可用容积百分比）
    public List<Map<String,String>> findNowhslock(){
        List<S_whs_status> List = mapper.findNowhslock();
        List<Map<String,String>> map = new ArrayList<>();
        double percent;
        for (S_whs_status i : List) {
            Map<String, String> map2 = new HashMap<>();
            map2.put("whs_id", i.getWhs_id());
            map2.put("whs_info", i.getWhs_info());
            map2.put("whs_allvol", i.getWhs_allvol());
            map2.put("whs_availvol", i.getWhs_availvol());
            percent = (Double.parseDouble(i.getWhs_availvol())/Double.parseDouble(i.getWhs_allvol()))*100;
            map2.put("vol_percent",String.valueOf(percent)+"%");
            map.add(map2);
        }
        return map;
    }

    public int add(S_whs_status one){
        return mapper.add(one);
    }

    public int delete(String id){
        return mapper.delete(id);
    }

    public int update(S_whs_status one){
        return mapper.update(one);
    }


    //根据仓位id单独更新仓位可用容积
    public int updateavailvol(String whs_id,String availvol){
        return mapper.updateAvailvol(whs_id, availvol);
    }

    //根据仓位id锁仓位并添加lock_id
    public int updatelock(String lock_id, String whs_id){
        return mapper.updateLock(lock_id, whs_id);
    }

    //根据仓位id进行仓位解锁，并吧lock_id设为null
    public int unlock(String whs_id){
        return mapper.unlock(whs_id);
    }
}
