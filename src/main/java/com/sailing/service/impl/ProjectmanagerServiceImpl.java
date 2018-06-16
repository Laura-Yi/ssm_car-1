package com.sailing.service.impl;

import com.sailing.dao.ProjectmanagerMapper;
import com.sailing.entity.Projectmanager;
import com.sailing.service.ProjectmanagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*@description: ProjectmanagerServiceImpl
*@date: 0:51 2018/6/15
*@author: yichaoqun
*/
@Service
public class ProjectmanagerServiceImpl implements ProjectmanagerService{

    @Resource
    ProjectmanagerMapper projectmanagerMapper;


    @Override
    public int insert(Projectmanager projectmanager) {
        projectmanagerMapper.insertSelective(projectmanager);
        return projectmanager.getId();
    }

    @Override
    public List<Projectmanager> selectProjectmanagerByTeacher(Integer teacherId) {
        return projectmanagerMapper.selectProjectmanagerByTeacher(teacherId);
    }

    @Override
    public Projectmanager selectProjectmanagerById(Integer projectId) {
        return projectmanagerMapper.selectByPrimaryKey(projectId);
    }

    @Override
    public void deleteProjectmanager(Integer projectId) {
        projectmanagerMapper.deleteByPrimaryKey(projectId);
    }

    @Override
    public void updateProject(Projectmanager projectmanager) {
        projectmanagerMapper.updateByPrimaryKeySelective(projectmanager);
    }

    @Override
    public List<Projectmanager> selectAllProjectmanager() {
        return projectmanagerMapper.selectAllProjectmanager();
    }
}
