package com.sailing.dao;

import com.sailing.entity.Projectmanager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectmanagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Projectmanager record);

    int insertSelective(Projectmanager record);

    Projectmanager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Projectmanager record);

    int updateByPrimaryKey(Projectmanager record);

    List<Projectmanager> selectProjectmanagerByTeacher(@Param("teacherId") Integer teacherId);

    List<Projectmanager> selectAllProjectmanager();
}