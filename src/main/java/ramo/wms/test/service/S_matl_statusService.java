package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.S_matl_statusMapper;
import ramo.wms.test.domain.S_matl_status;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class S_matl_statusService {
    @Autowired(required = false)
    private S_matl_statusMapper mapper;

    public List<S_matl_status> all(){
        return mapper.All();
    }


    public int add(S_matl_status one){
        return mapper.Add(one);
    }

    public int delete(Integer id){
        return mapper.Delete(id);
    }

    public int update(S_matl_status one){
        return mapper.Update(one);
    }
}
