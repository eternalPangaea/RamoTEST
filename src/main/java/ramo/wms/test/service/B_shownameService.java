package ramo.wms.test.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ramo.wms.test.dao.B_shownameMapper;
import ramo.wms.test.domain.B_show;
import ramo.wms.test.domain.B_showname;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class B_shownameService {

    @Autowired(required = false)
    private B_shownameMapper mapper;

    public int create(String table_name){
        return mapper.Create(table_name);
    }

    public int add(B_showname one){
        return mapper.Add(one);
    }

    public List<B_showname> all(){
        return mapper.All();
    }

    public int delete(String table_name){return mapper.Delete(table_name);}

    public int drop(String table_name){
        return mapper.Drop(table_name);
    }

    public List<Map<String,String>> findbytlname(String b_showname){
        List<B_show> List = mapper.findBytlname(b_showname);
        List<Map<String,String>> map = new ArrayList<>();
        for (B_show i:List) {
            Map<String, String> temp = new HashMap<>();
            temp.put("unit_id",i.getUnit_id());
            temp.put("b_location",i.getB_location());
            temp.put("level",i.getLevel());
            temp.put("unit_typeid",i.getUnit_typeid());
            temp.put("unit_statusid",String.valueOf(i.getUnit_statusid()));
            temp.put("real_location",i.getReal_location());
            map.add(temp);
        }
        return map;
    }
}
