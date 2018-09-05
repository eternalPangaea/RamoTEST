package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.S_whs_recordMapper;
import ramo.wms.test.domain.S_whs_record;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class S_whs_recordService {
    @Autowired(required = false)
    private S_whs_recordMapper mapper;

    public List<S_whs_record> all(){
        List<S_whs_record> List= mapper.all();
        return List;
    }

    //根据仓位ID查找
    public List<S_whs_record> findBywhsid(String id){
        List<S_whs_record> List= mapper.findBywhsId(id);
        return List;
    }

    //根据物品ID查找
    public List<S_whs_record> findBymatlid(String id){
        List <S_whs_record> List= mapper.findBymatlId(id);
        return List;
    }

    //根据物品ID查找并且返回没有上物品锁的
    public List<S_whs_record> findBymatlidNolock(String id){
        List<S_whs_record> List = mapper.findBymatlIdNolock(id);
        return List;
    }

    //在看板里给物品上锁（传入物品id，仓位id和logintlid（或者任务id））
    public int lockmatl(String whs_id, String matl_id, String lock_id){
        return mapper.lockMatl(whs_id, matl_id, lock_id);
    }

    //物品解锁, 并把lock_id设为null
    public int unlockmatl(String whs_id, String matl_id){
        return mapper.unlockMatl(whs_id, matl_id);
    }

    public int add(S_whs_record one){
        return mapper.add(one);
    }

    public int delete(String id){
        return mapper.delete(id);
    }

    public int update(S_whs_record one){
        return mapper.update(one);
    }

}
