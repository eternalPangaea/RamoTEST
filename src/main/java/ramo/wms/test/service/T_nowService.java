package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.T_nowMapper;
import ramo.wms.test.domain.S_whs_record;
import ramo.wms.test.domain.T_now;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class T_nowService {
    @Autowired(required = false)
    private T_nowMapper mapper;

    public List<T_now> all(){
        List<T_now> List= mapper.all();
        return List;
    }

    public T_now findByid(String id){
        T_now one= mapper.findById(id);
        return one;
    }

    //根据任务创建者和任务执行者查找,这里creator就是logintl_id
    public List<T_now> findCreatorObject(String creator, String object){
        List<T_now> List= mapper.findCreatorObject(creator, object);
        return List;
    }

    /*
    //根据任务创建者查找
    public List<T_now> findBycreator(String creator){
        List<T_now> List= mapper.findBycreator(creator);
        return List;
    }

    //根据任务执行者查找, 这里object就是logintl_id
    public List<T_now> findByobject(String object){
        List<T_now> List= mapper.findByobject(object);
        return List;
    }

    */

    public int add(T_now one){
        //以当前系统时间为任务创建时间
        Date date = new Date();
        Timestamp c_time = new Timestamp(date.getTime());
        one.setT_ctime(c_time.toString());
        return mapper.add(one);
    }

    public int delete(String id){
        return mapper.delete(id);
    }

    public int update(T_now one){
        return mapper.update(one);
    }

    //根据任务id，单独更新任务状态（例如是执行还是暂停）
    public int updateTstatus(String t_id, int t_statusid){
        return mapper.updateTstatus(t_id, t_statusid);
    }
}
