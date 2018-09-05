package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import ramo.wms.test.domain.E_matl_structure1;


import java.util.List;

@Component(value="E_matl_structure1Mapper")
@Mapper
public interface E_matl_structure1Mapper {
    @Select("select * from e_matl_structure1")
    public List<E_matl_structure1> all();

    @Select("select * from e_matl_structure1 WHERE matl_structid = #{matl_structid}")
    E_matl_structure1 findById(String id);

    //根据父目录查询
    @Select("select * from e_matl_structure1 WHERE matl_structparent = #{matl_structparent}")
    List <E_matl_structure1> findByparent(String parent);

    //根据是否是目录, 1代表是目录
    @Select("select * from e_matl_structure1 WHERE is_mulu = 1}")
    List <E_matl_structure1> findmulu();

    //!!!!!!!!!!!!!!!!!!根据角色权限查询，改权限可以得到的物品类型
    @Select("select * from e_matl_structure1 WHERE FIND_IN_SET(#{ch_ids},ch_ids)")
    List <E_matl_structure1> findBychid(String ch_ids);

    @Insert("insert into e_matl_structure1(matl_structid, matl_structparent, matl_structname, is_mulu, ch_ids) " +
            "VALUES(#{matl_structid}, #{matl_structparent}, #{matl_structname}, #{is_mulu}, #{ch_ids})")
    int add(E_matl_structure1 one);

    @Delete("delete from e_matl_structure1 where matl_structid = #{matl_structid}")
    int delete(String id);

    @Update("update e_matl_structure1 set matl_structid = #{matl_structid}, " +
            "matl_structparent = #{matl_structparent}, " +
            "matl_structname = #{matl_structname}, is_mulu = #{is_mulu}, ch_ids = #{ch_ids} where matl_structid = #{matl_structid}")
    int update(E_matl_structure1 one);

    //批量增加！！！！！！！！！！！！！！！！！！！！！
    @Insert("<script> insert into e_matl_structure1 (matl_structid, matl_structparent, matl_structname, is_mulu, ch_ids) VALUE " +
            "<foreach collection=\"list\" item=\"E_matl_structure1\" index=\"index\" separator =\",\">" +
            "(#{E_matl_structure1.matl_structid}, #{E_matl_structure1.matl_structparent}, #{E_matl_structure1.matl_structname}, #{E_matl_structure1.is_mulu}, #{E_matl_structure1.ch_ids}) </foreach></script>")
    int addlot(@Param("list") List<E_matl_structure1> list);
}
