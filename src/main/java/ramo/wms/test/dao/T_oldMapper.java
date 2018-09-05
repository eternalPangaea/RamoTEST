package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.T_old;

import java.util.List;

@Mapper
public interface T_oldMapper {
    @Select("select * from t_old")
    public List<T_old> all();

    @Select("select * from t_old WHERE t_id = #{t_id}")
    T_old findById(String id);

    @Select("select * from t_old WHERE t_creator = #{t_creator} or t_object = #{t_object}")
    List<T_old> findCreatorObject(@Param("t_creator") String creator, @Param("t_object") String Object);

    @Select("select * from t_old WHERE t_creator = #{t_creator}")
    List<T_old> findBycreator(String creator);

    @Select("select * from t_old WHERE t_object = #{t_object}")
    List<T_old> findByobject(String object);

    @Insert("insert into t_old(t_id, pr_id, t_typeid, " +
            "t_content, t_info, t_priority, t_object, " +
            "t_creator, t_ctime, t_req_stime, t_req_ftime, " +
            "t_rtime, t_stime, t_ftime, t_statusid, t_cvolume, is_divide) " +
            "VALUES(#{t_id}, #{pr_id}, #{t_typeid}, #{t_content}, " +
            "#{t_info}, #{t_priority}, #{t_object}, #{t_creator}, " +
            "#{t_ctime}, #{t_req_stime}, #{t_req_ftime}, #{t_rtime}, " +
            "#{t_stime}, #{t_ftime}, #{t_statusid}, #{t_cvolume}, #{is_divide})")
    int add(T_old one);

    @Delete("delete from t_old where t_id = #{t_id}")
    int delete(String id);

    @Update("update t_old set t_id = #{t_id}, pr_id = #{pr_id}, t_content = #{t_content}, t_info = #{t_info}, " +
            "t_priority = #{t_priority}, t_object = #{t_object}, t_creator = #{t_creator}, t_ctime = #{t_ctime}, " +
            "t_req_stime = #{t_req_stime}, t_req_ftime = #{t_req_ftime}, t_rtime = #{t_rtime}, t_stime = #{t_stime}, " +
            "t_ftime = #{t_ftime}, t_statusid = #{t_statusid}, t_cvolume = #{t_cvolume}, is_divide = #{is_divide} where t_id = #{t_id}")
    int update(T_old one);

}
