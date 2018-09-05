package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.E_matl_defMapper;
import ramo.wms.test.domain.E_matl_def;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class E_matl_defService {
    @Autowired(required = false)
    private E_matl_defMapper mapper;

    public List<E_matl_def> all(){
        List<E_matl_def> List= mapper.all();
        return List;
    }
    public E_matl_def findByid(String id){
        E_matl_def one= mapper.findById(id);
        return one;
    }

    public E_matl_def findByname(String name){
        E_matl_def one= mapper.findByname(name);
        return one;
    }

    public List<E_matl_def> findByparent(String matl_structname){
        List<E_matl_def> List = mapper.findByparent(matl_structname);
        return List;
    }

    public int add(E_matl_def one){
        return mapper.add(one);
    }

    public int delete(String id){
        return mapper.delete(id);
    }

    public int update(E_matl_def one){
        return mapper.update(one);
    }
}
