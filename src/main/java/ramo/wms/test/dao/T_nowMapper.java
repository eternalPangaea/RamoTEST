package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.S_whs_status;
import ramo.wms.test.domain.T_now;

import java.util.List;

@Mapper
public interface T_nowMapper {
    @Select("select * from t_now")
    public List<T_now> all();

    @Select("select * from t_now WHERE t_id = #{t_id}")
    T_now findById(String id);

    @Select("select * from t_now WHERE t_creator = #{t_creator} or t_object = #{t_object}")
    List<T_now> findCreatorObject(@Param("t_creator") String creator, @Param("t_object") String Object);

    @Select("select * from t_now WHERE t_creator = #{t_creator}")
    List<T_now> findBycreator(String creator);

    @Select("select * from t_now WHERE t_object = #{t_object}")
    List<T_now> findByobject(String object);

    @Insert("insert ignore into t_now(t_id, pr_id, t_typeid, " +
            "t_content, t_info, t_priority, t_object, " +
            "t_creator, t_ctime, t_req_stime, t_req_ftime, " +
            "t_rtime, t_stime, t_ftime, t_statusid, t_cvolume, is_divide) " +
            "VALUES(#{t_id}, #{pr_id}, #{t_typeid}, #{t_content}, " +
            "#{t_info}, #{t_priority}, #{t_object}, #{t_creator}, " +
            "#{t_ctime}, #{t_req_stime}, #{t_req_ftime}, #{t_rtime}, " +
            "#{t_stime}, #{t_ftime}, #{t_statusid}, #{t_cvolume}, #{is_divide})")
    public int add(T_now one);

    @Delete("delete from t_now where t_id = #{t_id}")
    int delete(String id);

    @Update("update t_now set t_id = #{t_id}, pr_id = #{pr_id}, t_content = #{t_content}, t_info = #{t_info}, " +
            "t_priority = #{t_priority}, t_object = #{t_object}, t_creator = #{t_creator}, t_ctime = #{t_ctime}, " +
            "t_req_stime = #{t_req_stime}, t_req_ftime = #{t_req_ftime}, t_rtime = #{t_rtime}, t_stime = #{t_stime}, " +
            "t_ftime = #{t_ftime}, t_statusid = #{t_statusid}, t_cvolume = #{t_cvolume}, is_divide = #{is_divide} where t_id = #{t_id}")
    int update(T_now one);

    @Update("update t_now set t_statusid = #{t_statusid} where t_id = #{t_id}")
    int updateTstatus(@Param("t_id") String t_id, @Param("t_statusid") Integer t_statusid);
}
