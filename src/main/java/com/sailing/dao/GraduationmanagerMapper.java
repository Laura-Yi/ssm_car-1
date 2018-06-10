package com.sailing.dao;

import com.sailing.entity.Graduationmanager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraduationmanagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Graduationmanager record);

    int insertSelective(Graduationmanager record);

    Graduationmanager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Graduationmanager record);

    int updateByPrimaryKey(Graduationmanager record);

    List<Graduationmanager> selectGraduationmanagerByTeacher(@Param("teacherId")Integer teacherId);
}