package com.sailing.service.impl;

import com.sailing.dao.GraduationmanagerMapper;
import com.sailing.entity.Graduationmanager;
import com.sailing.service.GraduationmanagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*@description:毕业论文模块
*@date: 12:19 2018/6/9
*@author: yichaoqun
*/
@Service
public class GraduationmanagerServiceImpl implements GraduationmanagerService {

    @Resource
    GraduationmanagerMapper graduationmanagerMapper;

    @Override
    public int insert(Graduationmanager graduationmanager) {
        graduationmanagerMapper.insertSelective(graduationmanager);
        return graduationmanager.getId();
    }

    @Override
    public List<Graduationmanager> selectGraduationmanagerByTeacher(Integer teacherId) {
        return graduationmanagerMapper.selectGraduationmanagerByTeacher(teacherId);
    }

    @Override
    public Graduationmanager selectGraduationmanagerById(Integer graduationId) {
        return graduationmanagerMapper.selectByPrimaryKey(graduationId);
    }

    @Override
    public void updateGraduationmanager(Graduationmanager graduationmanager) {
        graduationmanagerMapper.updateByPrimaryKeySelective(graduationmanager);
    }

    @Override
    public Graduationmanager selectGraduationmanagerByStudent(Integer studentId) {
        return graduationmanagerMapper.selectGraduationmanagerByStudent(studentId);
    }

    @Override
    public List<Graduationmanager> selectGraduationmanagerUnselected() {
        return graduationmanagerMapper.selectGraduationmanagerUnselected();
    }

    @Override
    public List<Graduationmanager> selectAllGraduationmanager() {
        return graduationmanagerMapper.selectAllGraduationmanager();
    }
}
