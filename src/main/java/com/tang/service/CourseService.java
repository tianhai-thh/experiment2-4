package com.tang.service;

import com.tang.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService {

    List<Course> queryAllCourse();

    Course queryById(int CourseId);

    Course queryCourseByName(String name);

    int addCourse(Course course);

    int updateCourse(Course course);

    int deleteCourseById(int CourseId);

    int queryamount(String name);

}
