package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.B_show;
import ramo.wms.test.domain.B_showname;

import java.util.List;

@Mapper
public interface B_shownameMapper {

    //动态建表，注意$和#区别
    @Update("CREATE TABLE IF NOT EXISTS ${table_name} (`unit_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, " +
            "`b_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL, " +
            "`level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL, " +
            "`unit_typeid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL, " +
            "`unit_statusid` int(11) NULL DEFAULT NULL, " +
            "`real_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL, " +
            " PRIMARY KEY (`unit_id`) USING BTREE) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci " +
            "ROW_FORMAT = Compact;")
    public int Create(@Param("table_name") String table_name);

    @Insert("insert into b_showname(id, name) VALUES(#{id}, #{name})")
    int Add(B_showname one);

    @Select("select * from b_showname")
    List<B_showname> All();


    @Delete("delete from b_showname where name = #{table_name}")
    int Delete(String table_name);

    //动态删表
    @Update("drop table if exists ${table_name}")
    int Drop(@Param("table_name") String table_name);

    @Select("select * from ${b_showname}")
    public List<B_show> findBytlname(@Param("b_showname") String b_showname);
}
