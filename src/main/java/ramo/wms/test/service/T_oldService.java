package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.T_oldMapper;
import ramo.wms.test.domain.T_old;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class T_oldService {
    @Autowired(required = false)
    private T_oldMapper mapper;

    public List<T_old> all(){
        List<T_old> List= mapper.all();
        return List;
    }

    public T_old findByid(String id){
        T_old one= mapper.findById(id);
        return one;
    }

    //根据任务创建者和任务执行者查找,这里creator就是logintl_id
    public List<T_old> findCreatorObject(String creator, String object){
        List<T_old> List= mapper.findCreatorObject(creator, object);
        return List;
    }

    /*
    //根据任务创建者查找
    public List<T_old> findBycreator(String creator){
        List<T_old> List= mapper.findBycreator(creator);
        return List;
    }
    //根据任务执行者查找
    public List<T_old> findByobject(String object){
        List<T_old> List= mapper.findByobject(object);
        return List;
    }
    */

    public int add(T_old one){
        return mapper.add(one);
    }

    public int delete(String id){
        return mapper.delete(id);
    }

    public int update(T_old one){
        return mapper.update(one);
    }


}
