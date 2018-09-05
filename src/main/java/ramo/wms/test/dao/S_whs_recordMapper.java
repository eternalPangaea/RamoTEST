package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.S_whs_record;

import java.util.List;

@Mapper
public interface S_whs_recordMapper {
    @Select("select * from s_whs_record")
    public List<S_whs_record> all();

    @Select("select * from s_whs_record WHERE whs_id = #{whs_id}")
    List<S_whs_record> findBywhsId(String id);

    @Select("select * from s_whs_record WHERE matl_id = #{matl_id}")
    List<S_whs_record> findBymatlId(String id);

    //根据物品id以及未上物品锁，获取物品
    @Select("select * from s_whs_record WHERE is_matllock = 0 and matl_id = #{matl_id}")
    public List<S_whs_record> findBymatlIdNolock(@Param("matl_id") String id);

    //在看板里给物品上物品锁
    @Update("update s_whs_record set is_matllock = 1, lock_id = #{lock_id} WHERE whs_id = #{whs_id} AND matl_id = #{matl_id}")
    int lockMatl(@Param("whs_id") String whs_id, @Param("matl_id") String matl_id, @Param("lock_id") String lock_id);

    //在看板里给物品锁解锁
    @Update("update s_whs_record set is_matllock = 0, lock_id = null WHERE whs_id = #{whs_id} AND matl_id = #{matl_id}")
    int unlockMatl(@Param("whs_id") String whs_id, @Param("matl_id") String matl_id);


    @Insert("insert into s_whs_record(recordtl_id, whs_id, matl_id, difference1, " +
            "difference2, quantity, danwei, wh_intime, is_matllock, " +
            "lock_id, pr_id, matl_statusid, picihao) " +
            "VALUES(#{recordtl_id}, #{whs_id}, #{matl_id}, #{difference1}, " +
            "#{difference2}, #{quantity}, #{danwei}, #{wh_intime}, " +
            "#{is_matllock}, #{lock_id}, #{pr_id}, #{matl_statusid}, #{picihao})")
    int add(S_whs_record one);

    @Delete("delete from s_whs_record where whs_id = #{whs_id}")
    int delete(String id);

    @Update("update s_whs_record set recordtl_id = #{recordtl_id}, whs_id = #{whs_id}, matl_id = #{matl_id}, " +
            "difference1 = #{difference1}, difference2 = #{difference2}, " +
            "quantity = #{quantity}, danwei = #{danwei}, wh_intime = #{wh_intime}, " +
            "is_matllock = #{is_matllock}, lock_id = #{lock_id}, pr_id = #{pr_id}, " +
            "matl_statusid = #{matl_statusid}, picihao = #{picihao} where whs_id = #{whs_id}")
    int update(S_whs_record one);
}
