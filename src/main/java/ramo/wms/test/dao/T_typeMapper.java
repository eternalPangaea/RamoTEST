package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.T_type;

import java.util.List;

@Mapper
public interface T_typeMapper {
    @Select("select * from t_type")
    public List<T_type> all();

    @Select("select * from t_type WHERE t_typeid = #{t_typeid}")
    T_type findById(Integer id);

    @Insert("insert into t_type(t_typeid, t_name, t_color) VALUES(#{t_typeid}, #{t_name}, #{t_color})")
    int add(T_type one);

    @Delete("delete from t_type where t_typeid = #{t_typeid}")
    int delete(Integer id);

    @Update("update t_type set t_typeid = #{t_typeid}, t_name = #{t_name}, t_color = #{t_color} where t_typeid = #{t_typeid}")
    int update(T_type one);
}
