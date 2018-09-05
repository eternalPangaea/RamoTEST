package ramo.wms.test.dao;

import org.apache.ibatis.annotations.*;
import ramo.wms.test.domain.E_login;

import java.util.List;
import java.util.Map;

@Mapper
public interface E_loginMapper {

    //搜索全部登陆人员
    @Select("select * from e_login")
    public List<E_login> all();

    //按照id进行搜索
    @Select("select * from e_login WHERE logintl_id = #{logintl_id}")
    E_login findByid(Integer logintl_id);

    //按照id进行搜索，返回除了密码以外的所有信息
    @Select("select user_name, login_source, ch_id, is_online, " +
            "image_file, nickname, phone, email, dept_id from e_login WHERE logintl_id = #{logintl_id}")
    Map<String,String> findAllInfo(Integer logintl_id);

    //按照用户名进行搜索
    @Select("select * from e_login WHERE user_name = #{user_name}")
    E_login findByname(String User_name);

    //按照用户名找密码
    @Select("select user_password from e_login WHERE user_name = #{user_name}")
    String findPass(String User_name);

    //按照用户名找logintl_id和nickname和头像
    @Select("select logintl_id, nickname,image_file from e_login WHERE user_name = #{user_name}")
    Map<String, String> findInfo(String User_name);

    //根据logintl_id查询角色权限id
    @Select("select ch_id from e_login WHERE logintl_id = #{logintl_id}")
    int findChid(Integer logintl_id);

    //根据logintl_id查询所属部门id
    @Select("select dept_id from e_login WHERE logintl_id = #{logintl_id}")
    int findDeptid(Integer logintl_id);

    //根据部门id查询人
    @Select("select * from e_login WHERE dept_id = #{dept_id}")
    List<E_login> findBydept(Integer dept_id);

    //插入一条新纪录
   @Insert("insert into e_login(user_name, " +
           "user_password, login_source," +
           "ch_id,is_online," +
           "image_file,nickname," +
           "phone,email,dept_id) " +
           "VALUES(#{user_name}, " +
           "#{user_password}, #{login_source}," +
           "#{ch_id},#{is_online}," +
           "#{image_file},#{nickname}," +
           "#{phone},#{email},#{dept_id})")
    int add(E_login e_login);

    //根据id删除一条记录
    @Delete("delete from e_login where logintl_id = #{logintl_id}")
    int delete(Integer logintl_id);


    //根据id，更新一条数据，如果一个字段不填那就会变成null
    @Update("update e_login set " +
            "user_name = #{user_name}, " +
            "user_password = #{user_password}, " +
            "login_source = #{login_source}, " +
            "ch_id = #{ch_id}, " +
            "is_online = #{is_online}, " +
            "image_file = #{image_file}, " +
            "nickname = #{nickname}, " +
            "phone = #{phone}, email = #{email}, dept_id = #{dept_id} where logintl_id = #{logintl_id}")
    int update(E_login e_login);
}
