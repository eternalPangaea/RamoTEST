package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.E_wh_structure;

import java.util.List;

@Mapper
public interface E_wh_structureMapper {
    @Select("select * from e_wh_structure")
    public List<E_wh_structure> all();

    //！！！！！！！！！！！！！！！！！关联s_whs_status表查询没有被锁的仓位
    @Select("SELECT wh_id, wh_parent, wh_name, is_mulu, whs_typeid, whs_size, whs_bearing FROM e_wh_structure LEFT JOIN s_whs_status ON e_wh_structure.wh_id = s_whs_status.whs_id WHERE s_whs_status.is_whslock = 0;")
    List<E_wh_structure> allwhsNolock();


    //！！！！！！！！！！！！！！！！！查询出所有仓库，不包括叉车, 仓位
    @Select("select * from e_wh_structure WHERE wh_parent <> 'C' AND is_mulu = 1")
    List<E_wh_structure> allwh();

    @Select("select * from e_wh_structure WHERE wh_id = #{wh_id}")
    E_wh_structure findById(String id);

    //根据父目录查询
    @Select("select * from e_wh_structure WHERE wh_parent = #{wh_parent}")
    List <E_wh_structure> findByparent(String parent);

    //根据是否是目录, 1代表是目录
    @Select("select * from e_wh_structure WHERE is_mulu = 1 ")
    List <E_wh_structure> findmulu();


    @Insert("insert into e_wh_structure(wh_id, wh_parent, wh_name, is_mulu, whs_typeids, whs_size, whs_bearing) " +
            "VALUES(#{wh_id}, #{wh_parent}, #{wh_name}, #{is_mulu}, #{whs_typeids}, #{whs_size}, #{whs_bearing})")
    int add(E_wh_structure one);

    @Delete("delete from e_wh_structure where wh_id = #{wh_id}")
    int delete(String id);

    @Update("update e_wh_structure set wh_id = #{wh_id}, wh_parent = #{wh_parent}, wh_name = #{wh_name}, " +
            "is_mulu = #{is_mulu}, whs_typeids = #{whs_typeids} , whs_size = #{whs_size}, whs_bearing = #{whs_bearing} " +
            "where wh_id = #{wh_id}")
    int update(E_wh_structure one);
}
