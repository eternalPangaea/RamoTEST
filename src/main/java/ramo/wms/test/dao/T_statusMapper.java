package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.T_status;

import java.util.List;

@Mapper
public interface T_statusMapper {
    @Select("select * from t_status")
    public List<T_status> all();

    @Select("select * from t_status WHERE t_statusid = #{t_statusid}")
    T_status findById(Integer id);

    @Insert("insert into t_status(t_statusid, t_statusinfo) VALUES(#{t_statusid}, #{t_statusinfo})")
    int add(T_status one);

    @Delete("delete from t_status where t_statusid = #{t_statusid}")
    int delete(Integer id);

    @Update("update t_status set t_statusid = #{t_statusid}, t_statusinfo = #{t_statusinfo} where t_statusid = #{t_statusid}")
    int update(T_status one);
}
