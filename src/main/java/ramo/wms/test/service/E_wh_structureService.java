package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.E_wh_structureMapper;
import ramo.wms.test.domain.E_wh_structure;
import ramo.wms.test.domain.S_whs_record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class E_wh_structureService {
    @Autowired(required = false)
    private E_wh_structureMapper mapper;

    @Autowired
    private S_whs_recordService s_whs_recordService;

    public List<E_wh_structure> all(){
        List<E_wh_structure> List= mapper.all();
        return List;
    }

    public List<E_wh_structure> allwhnolock(){
        List<E_wh_structure> List = mapper.allwhsNolock();
        return List;
    }

    public List<E_wh_structure> allwh(){
        List<E_wh_structure> List = mapper.allwh();
        return List;
    }

    public E_wh_structure findByid(String id){
        E_wh_structure one= mapper.findById(id);
        return one;
    }

    //根据父目录查找
    public List<Map<String, String>> findByparent(String parent){
        List<E_wh_structure> List= mapper.findByparent(parent);
        List<Map<String, String>> result = new ArrayList<>();
        for (E_wh_structure i : List) {
            List<S_whs_record> whs_records = s_whs_recordService.findBywhsid(i.getWh_id());
            for (S_whs_record j : whs_records) {
                Map<String,String> map = new HashMap<>();
                map.put("whs_id", j.getWhs_id());
                map.put("matl_id", j.getMatl_id());
                map.put("quantity", String.valueOf(j.getQuantity()));
                map.put("danwei", j.getDanwei());
                map.put("picihao", j.getPicihao());
                map.put("is_lock", String.valueOf(j.getIs_matllock()));
                result.add(map);
            }
        }
        return result;
    }

    //根据是否是目录查找（is_mulu == 1?）
    public List<E_wh_structure> findmulu(){
        List<E_wh_structure> List= mapper.findmulu();
        return List;
    }


    public int add(E_wh_structure one){
        return mapper.add(one);
    }

    public int delete(String id){
        return mapper.delete(id);
    }

    public E_wh_structureService() {
    }

    public int update(E_wh_structure one){
        return mapper.update(one);
    }
}
