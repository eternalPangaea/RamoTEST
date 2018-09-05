package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.E_authority_typeMapper;
import ramo.wms.test.domain.E_authority_type;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class E_authority_typeService {
    @Autowired(required = false)
    private E_authority_typeMapper mapper;

    public List<E_authority_type> all(){
        return mapper.All();
    }


    public int add(E_authority_type one){
        return mapper.Add(one);
    }

    public int delete(Integer id){
        return mapper.Delete(id);
    }

    public int update(E_authority_type one){
        return mapper.Update(one);
    }

}
