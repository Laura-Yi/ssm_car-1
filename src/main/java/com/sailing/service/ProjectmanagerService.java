package com.sailing.service;

import com.sailing.entity.Projectmanager;

import java.util.List;

/**
*@description: Service for 项目发布
*@date: 23:35 2018/6/14
*@author: yichaoqun
*/
public interface ProjectmanagerService {
    int insert(Projectmanager projectmanager);

    List<Projectmanager> selectProjectmanagerByTeacher(Integer id);

    Projectmanager selectProjectmanagerById(Integer projectId);

    void deleteProjectmanager(Integer projectId);

    void updateProject(Projectmanager projectmanager);

    List<Projectmanager> selectAllProjectmanager();
}
