package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.T_typeMapper;
import ramo.wms.test.domain.T_type;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class T_typeService {
    @Autowired(required = false)
    private T_typeMapper mapper;

    public List<T_type> all(){
        List<T_type> List= mapper.all();
        return List;
    }
    public T_type findByid(Integer id){
        T_type one= mapper.findById(id);
        return one;
    }

    public int add(T_type one){
        return mapper.add(one);
    }

    public int delete(Integer id){
        return mapper.delete(id);
    }

    public int update(T_type one){
        return mapper.update(one);
    }
}
