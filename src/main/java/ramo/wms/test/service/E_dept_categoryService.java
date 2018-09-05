package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.E_dept_categoryMapper;
import ramo.wms.test.domain.E_dept_category;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class E_dept_categoryService {
    @Autowired(required = false)
    private E_dept_categoryMapper mapper;

    public List<E_dept_category> all(){
        List<E_dept_category> List= mapper.all();
        return List;
    }
    public E_dept_category findByid(Integer id){
        E_dept_category one= mapper.findById(id);
        return one;
    }

    public E_dept_category findByname(String name){
        E_dept_category one= mapper.findByname(name);
        return one;
    }

    public String findSubdept(Integer id){
        return mapper.findSubdept(id);
    }

    public List<E_dept_category> findBysubdept(String subdept_ids){
        return mapper.findBysubdept(subdept_ids);
    }

    public int add(E_dept_category one){
        return mapper.add(one);
    }

    public int delete(Integer id){
        return mapper.delete(id);
    }

    public int update(E_dept_category one){
        return mapper.update(one);
    }
}
