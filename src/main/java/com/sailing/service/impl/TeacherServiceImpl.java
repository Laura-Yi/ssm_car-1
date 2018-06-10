package com.sailing.service.impl;

import com.sailing.dao.TeacherMapper;
import com.sailing.entity.Teacher;
import com.sailing.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
*@description: ServiceImpl For Admin
*@date: 18:17 2018/6/5
*@author: yichaoqun
*/
@Service
public class TeacherServiceImpl implements TeacherService{

    @Resource
    TeacherMapper teacherMapper;

    @Override
    public Teacher checkLogin(String username, String password) {
        Teacher teacher = teacherMapper.selectByUsername(username);
        if (teacher != null && teacher.getPassword().equals(password)) {
            return teacher;
        } else return null;
    }

    @Override
    public Teacher selectTeacherById(Integer teacher) {
        return teacherMapper.selectByPrimaryKey(teacher);
    }
}
