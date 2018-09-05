package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import ramo.wms.test.domain.E_danwei;



import java.util.List;
@Component(value="E_danweiMapper")
@Mapper
public interface E_danweiMapper {
    @Select("select * from e_danwei")
    public List<E_danwei> all();


    @Select("select * from e_danwei WHERE danwei_id = #{danwei_id}")
    E_danwei findById(Integer id);

    @Select("select * from e_danwei WHERE danwei_name = #{danwei_name}")
    E_danwei findByname(String name);


    @Insert("insert into e_danwei(danwei_id, danwei_name) VALUES(#{danwei_id}, #{danwei_name})")
    int add(E_danwei one);

    @Delete("delete from e_danwei where danwei_id = #{danwei_id}")
    int delete(Integer id);

    @Update("update e_danwei set danwei_id = #{danwei_id}, danwei_name = #{danwei_name} where danwei_id = #{danwei_id}")
    int update(E_danwei one);


    //批量添加
    @Insert ("<script> insert into e_danwei (danwei_id, danwei_name) VALUE " +
            "<foreach collection=\"list\" item=\"E_danwei\" index=\"index\" separator =\",\">" +
            "(#{E_danwei.danwei_id}, #{E_danwei.danwei_name}) </foreach></script>")
    Integer addlots(@Param(value = "list") List<E_danwei> list);



}
