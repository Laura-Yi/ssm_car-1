package com.sailing.service;

import com.sailing.entity.Classroom;

import java.util.List;

/**
*@description: ClassroomService
*@date: 17:20 2018/6/16
*@author: yichaoqun
*/
public interface ClassroomService {
    List<Classroom> selectAllClassroom();

    void insert(Classroom classroom);

    Classroom selectClassroomById(Integer classroom);
}
