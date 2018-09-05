package ramo.wms.test.dao;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import ramo.wms.test.domain.E_dept_category;

import java.util.List;

@Component(value="E_dept_categoryMapper")
@Mapper
public interface E_dept_categoryMapper {
    @Select("select * from e_dept_category")
    public List<E_dept_category> all();


    @Select("select * from e_dept_category WHERE dept_id = #{dept_id}")
    E_dept_category findById(Integer id);

    @Select("select * from e_dept_category WHERE dept_name = #{dept_name}")
    E_dept_category findByname(String name);

    //根据部门id，查找下属部门id
    @Select("select subdept_ids from e_dept_category WHERE dept_id = #{dept_id}")
    String findSubdept(Integer id);

    //!!!!!!!!!利用in，查找多个部门（这里运用于查找一个部门下的所有下属部门）
    @Select("select * from e_dept_category WHERE dept_id in (${subdept_ids})")
    List<E_dept_category> findBysubdept(@Param("subdept_ids") String subdept_ids);

    @Insert("insert into e_dept_category(dept_id, dept_name, subdept_ids) VALUES(#{dept_id}, #{dept_name}, #{subdept_ids})")
    int add(E_dept_category one);

    @Delete("delete from e_dept_category where dept_id = #{dept_id}")
    int delete(Integer id);

    @Update("update e_dept_category set dept_id = #{dept_id}, dept_name = #{dept_name}, subdept_ids = #{subdept_ids} where dept_id = #{dept_id}")
    int update(E_dept_category one);
}
