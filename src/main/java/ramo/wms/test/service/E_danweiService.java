package ramo.wms.test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.E_danweiMapper;
import ramo.wms.test.domain.E_danwei;


import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class E_danweiService {
    @Autowired(required = false)
    private E_danweiMapper mapper;

    public List<E_danwei> all(){
        List<E_danwei> List= mapper.all();
        return List;
    }
    public E_danwei findByid(Integer id){
        E_danwei one= mapper.findById(id);
        return one;
    }

    public E_danwei findByname(String name){
        E_danwei one= mapper.findByname(name);
        return one;
    }

    public int add(E_danwei one){
        return mapper.add(one);
    }

    public int delete(Integer id){
        return mapper.delete(id);
    }

    public int update(E_danwei one){
        return mapper.update(one);
    }

    public int addlots(List<E_danwei> ones){
        return mapper.addlots(ones);
    }
}

