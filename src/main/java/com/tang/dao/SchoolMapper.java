package com.tang.dao;

import com.tang.pojo.School;

import java.util.List;

public interface SchoolMapper {
    int selectcsid(String name);

    List<School> selectAll();
}
