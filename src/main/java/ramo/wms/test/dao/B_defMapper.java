package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.B_def;

import java.util.List;
import java.util.Map;

@Mapper
public interface B_defMapper {

    @Select("select * from b_def")
    public List<B_def> All();

    @Select("select * from b_def WHERE b_id=#{id}")
    B_def findByid(Integer id);

    //获取所有看板id和看板名称
    @Select("select b_id, b_name from b_def")
    List<Map<String, String>> Allidname();

    @Insert("insert into b_def(b_id, b_name, b_showname, real_location1, real_location2, bg_pic, resolution) " +
            "VALUES(#{b_id}, #{b_name}, #{b_showname}, #{real_location1}, #{real_location2}, #{bg_pic}, #{resolution})")
    int Add(B_def one);

    @Update("update b_def set b_id = #{b_id}, b_name = #{b_name}, b_showname = #{b_showname}")
    int Update(B_def one);

    @Delete("delete from b_def WHERE b_id=#{id}")
    int Delete(Integer id);
}
