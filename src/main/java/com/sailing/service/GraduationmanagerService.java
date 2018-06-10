package com.sailing.service;

import com.sailing.entity.Graduationmanager;

import java.util.List;

/**
*@description: 毕业论文模块Service
*@date: 12:15 2018/6/9
*@author: yichaoqun
*/
public interface GraduationmanagerService {
    /**
     * 添加论文模块
     * @param graduationmanager
     * @return
     */
    public int insert(Graduationmanager graduationmanager);

    List<Graduationmanager> selectGraduationmanagerByTeacher(Integer id);

    Graduationmanager selectGraduationmanagerById(Integer graduationId);

    void updateGraduationmanager(Graduationmanager graduationmanager);

    Graduationmanager selectGraduationmanagerByStudent(Integer id);

    List<Graduationmanager> selectGraduationmanagerUnselected();

    List<Graduationmanager> selectAllGraduationmanager();
}
