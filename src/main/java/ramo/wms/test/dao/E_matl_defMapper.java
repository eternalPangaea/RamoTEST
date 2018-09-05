package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.E_matl_def;

import java.util.List;

@Mapper
public interface E_matl_defMapper {
    @Select("select * from e_matl_def")
    public List<E_matl_def> all();


    @Select("select * from e_matl_def WHERE matl_id = #{matl_id}")
    E_matl_def findById(String id);

    @Select("select * from e_matl_def WHERE matl_name = #{matl_name}")
    E_matl_def findByname(String name);

    //根据父目录，查找旗下的物品
    @Select("select * from e_matl_def WHERE matl_parent = #{matl_parent}")
    public List<E_matl_def> findByparent(String parent);

    @Insert("insert into e_matl_def(matl_id, matl_name, " +
            "matl_structure, matl_parent, " +
            "model, brand, " +
            "difference1, difference2, " +
            "min_danwei, danwei1, " +
            "danwei2, relat_danwei1, " +
            "relat_danwei2, relat_danwei12) " +
            "VALUES(#{matl_id}, #{matl_name}, " +
            "#{matl_structure}, #{matl_parent}, " +
            "#{model}, #{brand}, " +
            "#{difference1}, #{difference2}, " +
            "#{min_danwei}, #{danwei1}, " +
            "#{danwei2}, #{relat_danwei1}, " +
            "#{relat_danwei2}, #{relat_danwei12})")
    int add(E_matl_def one);

    @Delete("delete from e_matl_def where matl_id = #{matl_id}")
    int delete(String id);

    @Update("update e_matl_def set matl_id = #{matl_id}, matl_name = #{matl_name}, " +
            "matl_structure = #{matl_structure}, matl_parent = #{matl_parent}, " +
            "model = #{model}, brand = #{brand}, " +
            "difference1 = #{difference1}, difference2 = #{difference2}, " +
            "min_danwei = #{min_danwei}, danwei1 = #{danwei1}, " +
            "danwei2 = #{danwei2}, relat_danwei1 = #{relat_danwei1}, " +
            "relat_danwei2 = #{relat_danwei2}, relat_danwei12 = #{relat_danwei12} where matl_id = #{matl_id}")
    int update(E_matl_def one);
}

