package com.sailing.service.impl;

import com.sailing.dao.EducationplanMapper;
import com.sailing.dao.SchedulecourseMapper;
import com.sailing.entity.Educationplan;
import com.sailing.entity.Schedulecourse;
import com.sailing.service.SchedulecourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yichaoqun on 2018/6/16.
 */
@Service
public class SchedulecourseServiceImpl implements SchedulecourseService {

    @Resource
    SchedulecourseMapper schedulecourseMapper;

    @Resource
    EducationplanMapper educationplanMapper;

    /**
     * 添加教室添加教学计划
     * @param classroomId
     */
    @Override
    public void insertByClassroom(Integer classroomId) {
        Schedulecourse schedulecourse = new Schedulecourse();
        for(int i = 0;i<25;i++){
            schedulecourse.setClassroom(classroomId);
            schedulecourse.setTime(i);
            schedulecourseMapper.insertSelective(schedulecourse);
            schedulecourse.setId(null);
        }
    }

    @Override
    public int insert(Schedulecourse schedulecourse) {
        schedulecourseMapper.insertSelective(schedulecourse);
        return schedulecourse.getId();
    }


    @Override
    public void updateScheduleByClassAndTime(Integer educationplanId, Integer classroom, Integer time) {
        Educationplan educationplan = new Educationplan();
        educationplan.setId(educationplanId);
        educationplan.setTerm("select");
        educationplanMapper.updateByPrimaryKeySelective(educationplan);
        schedulecourseMapper.updateScheduleByClassAndTime(educationplanId,classroom,time);
    }

    @Override
    public List<Integer> selectUnScheduleIds() {
        return schedulecourseMapper.selectUnScheduleIds();
    }

    @Override
    public void updateScheduleAuto(Schedulecourse schedulecourse) {
        schedulecourseMapper.updateByPrimaryKeySelective(schedulecourse);
        Educationplan educationplan = new Educationplan();
        educationplan.setId(schedulecourse.getEducationplan());
        educationplan.setTerm("select");
        educationplanMapper.updateByPrimaryKeySelective(educationplan);
    }

    @Override
    public List<Schedulecourse> selectScheduleByClassId(Integer classroomId) {
        return schedulecourseMapper.selectScheduleByClassId(classroomId);
    }

    @Override
    public Schedulecourse selectScheduleByClassAndTime(Integer classroom, Integer time) {
        return schedulecourseMapper.selectScheduleByClassAndTime(classroom,time);
    }

    @Override
    public Schedulecourse selectScheduleByeducationId(Integer educationplanId) {
        return schedulecourseMapper.selectScheduleByeducationId(educationplanId);
    }

}
