package com.sailing.service;

import com.sailing.entity.Educationplan;

import java.util.List;

/**
*@description:EducationplanService
*@date: 19:09 2018/6/16
*@author: yichaoqun
*/
public interface EducationplanService {
    int insert(Educationplan educationplan);

    List<Educationplan> selectEducationplanUnselected();

    Educationplan selectEducationplanById(Integer educationplanId);

    List<Educationplan> selectEducationplanByTeacher(Integer teacher);
}
