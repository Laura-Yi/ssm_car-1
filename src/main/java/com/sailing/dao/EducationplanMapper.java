package com.sailing.dao;

import com.sailing.entity.Educationplan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationplanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Educationplan record);

    int insertSelective(Educationplan record);

    Educationplan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Educationplan record);

    int updateByPrimaryKey(Educationplan record);

    List<Educationplan> selectEducationplanUnselected();

    List<Educationplan> selectEducationplanByTeacher(@Param("teacher") Integer teacher);
}