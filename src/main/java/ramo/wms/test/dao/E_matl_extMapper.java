package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.E_matl_ext;

import java.util.List;

@Mapper
public interface E_matl_extMapper {

    @Select("select * from e_matl_ext")
    public List<E_matl_ext> all();

    @Select("select * from e_matl_ext WHERE matl_id = #{matl_id}")
    E_matl_ext findById(String id);

    @Insert("insert into e_matl_ext(matl_id, matl_ext) VALUES(#{matl_id}, #{matl_ext})")
    int add(E_matl_ext one);

    @Delete("delete from e_matl_ext where matl_id = #{matl_id}")
    int delete(String id);

    @Update("update e_matl_ext set matl_id = #{matl_id}, matl_ext = #{matl_ext} where matl_id = #{matl_id}")
    int update(E_matl_ext one);
}
