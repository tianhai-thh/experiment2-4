package com.tang.dao;

import com.tang.pojo.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CourseMapper {

        @Select("select * from course order by sid asc")
        List<Course> queryAllCourse();

        @Select("select * from mybatis.course where CourseId = #{CourseId};")
        Course queryById(@Param(value = "CourseId")int CourseId);

        @Select("select count(*) from course where name=#{name}")
        int queryamount(@Param(value = "name")String name);

        @Select("select * from course where mybatis.course.name= #{name} " )
        Course queryCourseByName(@Param(value = "name")String name);
        @Insert("insert into mybatis.course(name, hours, sid)" +
                " values (#{name}, #{hours}, #{sid});")
        int addCourse(Course course);

        @Update("update mybatis.course " +
                "set name=#{name},hours=#{hours},sid=#{sid} " +
                "where CourseId= #{CourseId};")
        int updateCourse(Course course);

        @Delete("delete from mybatis.course\n" +
                "where CourseId = #{CourseId};")
        int deleteCourseById(@Param(value = "CourseId")int CourseId);

}
