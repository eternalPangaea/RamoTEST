package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.E_matl_structure2Mapper;
import ramo.wms.test.domain.E_matl_structure2;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class E_matl_structure2Service {
    @Autowired(required = false)
    private E_matl_structure2Mapper mapper;

    public List<E_matl_structure2> all(){
        List<E_matl_structure2> List= mapper.all();
        return List;
    }
    public E_matl_structure2 findByid(String id){
        E_matl_structure2 one= mapper.findById(id);
        return one;
    }

    //根据父目录查找
    public List<E_matl_structure2> findByparent(String parent){
        List<E_matl_structure2> List= mapper.findByparent(parent);
        return List;
    }

    //根据是否是目录查找（is_mulu == 1?）
    public List<E_matl_structure2> findmulu(){
        List<E_matl_structure2> List= mapper.findmulu();
        return List;
    }

    //根据角色权限id查找其权限下的物品目录
    public List<E_matl_structure2> findBychid(String  ch_ids){
        List<E_matl_structure2> List= mapper.findBychid(ch_ids);
        return List;
    }

    public int add(E_matl_structure2 one){
        return mapper.add(one);
    }

    public int delete(String id){
        return mapper.delete(id);
    }

    public int update(E_matl_structure2 one){
        return mapper.update(one);
    }
}
