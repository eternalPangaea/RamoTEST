package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.S_matl_status;

import java.util.List;

@Mapper
public interface S_matl_statusMapper {
    @Select("select * from s_matl_status")
    public List<S_matl_status> All();

    @Insert("insert into s_matl_status(whs_statusid, whs_statusinfo) VALUES(#{whs_statusid}, #{whs_statusinfo})")
    int Add(S_matl_status one);

    @Update("update s_matl_status set whs_statusid = #{whs_statusid}, whs_statusinfo = #{whs_statusinfo} where whs_statusid = #{whs_statusid}")
    int Update(S_matl_status one);

    @Delete("delete from s_matl_status where danwei_id = #{danwei_id}")
    int Delete(Integer id);
}
