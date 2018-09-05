package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.E_dept_categoryMapper;
import ramo.wms.test.dao.E_matl_extMapper;
import ramo.wms.test.domain.E_dept_category;
import ramo.wms.test.domain.E_matl_ext;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class E_matl_extService {
    @Autowired(required = false)
    private E_matl_extMapper mapper;

    public List<E_matl_ext> all(){
        List<E_matl_ext> List= mapper.all();
        return List;
    }

    public E_matl_ext findByid(String id){
        E_matl_ext one= mapper.findById(id);
        return one;
    }

    public int add(E_matl_ext one){
        return mapper.add(one);
    }

    public int delete(String id){
        return mapper.delete(id);
    }

    public int update(E_matl_ext one){
        return mapper.update(one);
    }
}
