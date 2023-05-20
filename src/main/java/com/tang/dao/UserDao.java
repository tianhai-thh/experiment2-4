package com.tang.dao;

import com.tang.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select * from users where email = #{email} and password = #{password}")
    User select(@Param("email") String email,@Param("password")  String password);


    @Select("select * from users where email = #{email}")
    User selectByUseremail(@Param("email") String email);


    @Insert("insert into users values(null,#{email},#{password})")
    Boolean register(User user);
}
