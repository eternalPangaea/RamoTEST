package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.B_defMapper;
import ramo.wms.test.domain.B_def;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class B_defService {

    @Autowired(required = false)
    private B_defMapper mapper;

    public List<B_def> all(){
        return mapper.All();
    }

    public List<Map<String, String>> allidname(){
        List<Map<String, String>> temp  = mapper.Allidname();
        List<Map<String, String>> list = new ArrayList<>();
        //由于返回b_id是int所以需要做转换
        for (Map<String, String> i: temp) {
            Map<String, String> map1 = new HashMap<>();
            map1.put("b_id",String.valueOf(i.get("b_id")));
            map1.put("b_name", i.get("b_name"));
            list.add(map1);
        }
        return list;
    }

    public B_def findbyid(int id){
        return mapper.findByid(id);
    }

    public int add(B_def one){
        return mapper.Add(one);
    }

    public int delete(int id){
        return mapper.Delete(id);
    }

    public int update(B_def one){
        return mapper.Update(one);
    }
}
