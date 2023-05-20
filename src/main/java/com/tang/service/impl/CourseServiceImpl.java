package com.tang.service.impl;

import com.tang.dao.CourseMapper;
import com.tang.pojo.Course;
import com.tang.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjzhou
 * @version 1.0
 */

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> queryAllCourse() {
        return courseMapper.queryAllCourse();
    }

    @Override
    public Course queryById(int CourseId) {
        return courseMapper.queryById(CourseId);
    }

    @Override
    public Course queryCourseByName(String name) {
        return courseMapper.queryCourseByName(name);
    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public int deleteCourseById(int CourseId) {
        return courseMapper.deleteCourseById(CourseId);
    }

    @Override
    public int queryamount(String name) {
        return courseMapper.queryamount(name);
    }


}
