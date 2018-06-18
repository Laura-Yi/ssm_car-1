package com.sailing.service.impl;

import com.sailing.dao.ClassroomMapper;
import com.sailing.entity.Classroom;
import com.sailing.service.ClassroomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*@description: ClassroomServiceImpl
*@date: 17:21 2018/6/16
*@author: yichaoqun
*/
@Service
public class ClassroomServiceImpl implements ClassroomService{

    @Resource
    ClassroomMapper classroomMapper;

    @Override
    public List<Classroom> selectAllClassroom() {
        return classroomMapper.selectAllClassroom();
    }

    @Override
    public void insert(Classroom classroom) {
        classroomMapper.insertSelective(classroom);
    }

    @Override
    public Classroom selectClassroomById(Integer classroom) {
        return classroomMapper.selectByPrimaryKey(classroom);
    }
}
