package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.T_statusMapper;
import ramo.wms.test.domain.T_status;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class T_statusService {
    @Autowired(required = false)
    private T_statusMapper mapper;

    public List<T_status> all(){
        List<T_status> List= mapper.all();
        return List;
    }
    public T_status findByid(Integer id){
        T_status one= mapper.findById(id);
        return one;
    }

    public int add(T_status one){
        return mapper.add(one);
    }

    public int delete(Integer id){
        return mapper.delete(id);
    }

    public int update(T_status one){
        return mapper.update(one);
    }

}
