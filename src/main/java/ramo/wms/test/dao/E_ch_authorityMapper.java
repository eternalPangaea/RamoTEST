package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.E_ch_authority;
import java.util.List;

@Mapper
public interface E_ch_authorityMapper {
    @Select("select * from e_ch_authority")
    public List<E_ch_authority> all();


    @Select("select * from e_ch_authority WHERE ch_id = #{ch_id}")
    E_ch_authority findById(Integer id);

    @Select("select * from e_ch_authority WHERE ch_authorityname = #{ch_authorityname}")
    E_ch_authority findByname(String name);


    @Insert("insert into e_ch_authority(ch_id, ch_authorityname, authority_ids) VALUES(#{ch_id}, #{ch_authorityname}, #{authority_ids})")
    int add(E_ch_authority one);

    @Delete("delete from e_ch_authority where ch_id = #{ch_id}")
    int delete(Integer id);

    @Update("update e_ch_authority set ch_id = #{ch_id}, ch_authorityname = #{ch_authorityname}, authority_ids = #{authority_ids} where ch_id = #{ch_id}")
    int update(E_ch_authority one);
}
