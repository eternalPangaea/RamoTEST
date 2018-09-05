package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.E_authority_type;

import java.util.List;

@Mapper
public interface E_authority_typeMapper {

    @Select("select * from e_authority_type")
    List<E_authority_type> All();

    @Insert("insert into e_authority_type(authority_id,authority_name) VALUES(#{authority_id},#{authority_name})")
    int Add(E_authority_type one);

    @Delete("delete from e_authority_type WHERE authority_id = #{authority_id}")
    int Delete(Integer authority_id);

    @Update("update e_authority_type set authority_id = #{authority_id}, authority_name = #{authority_name} WHERE authority_id = #{authority_id}")
    int Update(E_authority_type one);
}
