package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.B_unittype_defMapper;
import ramo.wms.test.domain.B_unittype_def;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class B_unittype_defService {
    @Autowired(required = false)
    private B_unittype_defMapper mapper;

    //返回所有的看板单元类型定义，并封装成json
    public  List<Map<String, String>> all(){
        List<B_unittype_def> b_unittype_defs = mapper.All();
        List<Map<String, String>> list = new ArrayList<>();
        for (B_unittype_def i:b_unittype_defs) {
            Map<String, String> map = new HashMap<>();
            map.put("unit_typeid", String.valueOf(i.getUnit_typeid()));
            map.put("unit_typename", i.getUnit_typename());
            map.put("pic_location", i.getPic_location());
            list.add(map);
        }
        return list;
    }

}
