package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.E_ch_authorityMapper;
import ramo.wms.test.domain.E_ch_authority;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class E_ch_authorityService {
    @Autowired(required = false)
    private E_ch_authorityMapper mapper;

    public List<E_ch_authority> all(){
        List<E_ch_authority> List= mapper.all();
        return List;
    }
    public E_ch_authority findByid(Integer id){
        E_ch_authority one= mapper.findById(id);
        return one;
    }

    public E_ch_authority findByname(String name){
        E_ch_authority one= mapper.findByname(name);
        return one;
    }

    public int add(E_ch_authority one){
        return mapper.add(one);
    }

    public int delete(Integer id){
        return mapper.delete(id);
    }

    public int update(E_ch_authority one){
        return mapper.update(one);
    }
}

