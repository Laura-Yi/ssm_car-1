package com.sailing.dao;

import com.sailing.entity.Graduationmanager;
import org.springframework.stereotype.Repository;

@Repository
public interface GraduationmanagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Graduationmanager record);

    int insertSelective(Graduationmanager record);

    Graduationmanager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Graduationmanager record);

    int updateByPrimaryKey(Graduationmanager record);
}