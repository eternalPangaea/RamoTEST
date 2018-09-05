package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.E_matl_structure2;

import java.util.List;

@Mapper
public interface E_matl_structure2Mapper {
    @Select("select * from e_matl_structure2")
    public List<E_matl_structure2> all();

    @Select("select * from e_matl_structure2 WHERE matl_structid = #{matl_structid}")
    E_matl_structure2 findById(String id);

    //根据父目录查询
    @Select("select * from e_matl_structure2 WHERE matl_structparent = #{matl_structparent}")
    List <E_matl_structure2> findByparent(String parent);

    //根据是否是目录, 1代表是目录
    @Select("select * from e_matl_structure2 WHERE is_mulu = 1}")
    List <E_matl_structure2> findmulu();

    //根据角色权限查询，改权限可以得到的物品类型
    @Select("select * from e_matl_structure2 WHERE FIND_IN_SET(#{ch_ids},ch_ids)")
    List <E_matl_structure2> findBychid(String  ch_ids);

    @Insert("insert into e_matl_structure2(matl_structid, matl_structparent, matl_structname, is_mulu, ch_ids) " +
            "VALUES(#{matl_structid}, #{matl_structparent}, #{matl_structname}, #{is_mulu}, #{ch_ids})")
    int add(E_matl_structure2 one);

    @Delete("delete from e_matl_structure2 where matl_structid = #{matl_structid}")
    int delete(String id);

    @Update("update e_matl_structure2 set matl_structid = #{matl_structid}, " +
            "matl_structparent = #{matl_structparent}, " +
            "matl_structname = #{matl_structname}, is_mulu = #{is_mulu}, ch_authorityid = #{ch_ids} where matl_structid = #{matl_structid}")
    int update(E_matl_structure2 one);
}
