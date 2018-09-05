package ramo.wms.test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ramo.wms.test.domain.B_unittype_def;

import java.util.List;

@Mapper
public interface B_unittype_defMapper {

    @Select("select * from b_unittype_def")
    public List<B_unittype_def> All();



}
