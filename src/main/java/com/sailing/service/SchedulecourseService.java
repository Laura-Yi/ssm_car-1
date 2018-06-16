package com.sailing.service;

import com.sailing.entity.Schedulecourse;

import java.util.List;

/**
*@description:SchedulecourseService
*@date: 18:30 2018/6/16
*@author: yichaoqun
*/
public interface SchedulecourseService {
    void insertByClassroom(Integer classroomId);

    int insert(Schedulecourse schedulecourse);

    void updateScheduleByClassAndTime(Integer educationplanId, Integer classroom, Integer time);

    List<Integer> selectUnScheduleIds();

    void updateScheduleAuto(Schedulecourse schedulecourse);


    List<Schedulecourse> selectScheduleByClassId(Integer classroomId);

    Schedulecourse selectScheduleByClassAndTime(Integer classroom, Integer time);
}
