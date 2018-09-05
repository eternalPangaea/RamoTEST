package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.S_whs_status;

import java.util.List;

@Mapper
public interface S_whs_statusMapper {
    @Select("select * from s_whs_status")
    public List<S_whs_status> all();

    @Select("select * from s_whs_status WHERE whs_id = #{whs_id}")
    S_whs_status findById(String id);

    @Select("select * from s_whs_status WHERE is_whslock = 0")
    List<S_whs_status> findNowhslock();

    @Insert("insert into s_whs_status(whs_id, is_inout, " +
            "is_whslock, lock_id, " +
            "whs_wanringid, env_id, " +
            "whs_info, whs_allvol, whs_availvol) " +
            "VALUES(#{whs_id}, #{is_inout}, " +
            "#{is_whslock}, #{lock_id}, " +
            "#{whs_wanringid}, #{env_id}, " +
            "#{whs_info}, #{whs_allvol}, #{whs_availvol})")
    int add(S_whs_status one);

    @Delete("delete from s_whs_status where whs_id = #{whs_id}")
    int delete(String id);

    @Update("update s_whs_status set whs_id = #{whs_id}, is_inout = #{is_inout}, is_whslock = #{is_whslock}, lock_id = #{lock_id}, whs_wanringid = #{whs_wanringid}, env_id = #{env_id}, whs_info = #{whs_info}, whs_allvol = #{whs_allvol}, whs_availvol = #{whs_availvol} where whs_id = #{whs_id}")
    int update(S_whs_status one);

    @Update("update s_whs_status set whs_availvol = #{availvol} where whs_id = #{whs_id}")
    int updateAvailvol(@Param("whs_id") String whs_id, @Param("availvol") String availvol);

    //根据仓位id进行上锁
    @Update("update s_whs_status set is_whslock = 1, lock_id = #{lock_id} WHERE whs_id = #{whs_id}")
    int updateLock(@Param("lock_id") String lock_id, @Param("whs_id") String whs_id);

    //仓位解锁
    @Update("update s_whs_status set is_whslock = 0, lock_id = null WHERE whs_id = #{whs_id}")
    int unlock(@Param("whs_id") String whs_id);
}
