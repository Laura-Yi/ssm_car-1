package com.sailing.service.impl;

import com.sailing.dao.StudentMapper;
import com.sailing.dao.TeacherMapper;
import com.sailing.entity.Student;
import com.sailing.entity.Teacher;
import com.sailing.service.StudentService;
import com.sailing.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
*@description: ServiceImpl For Admin
*@date: 18:17 2018/6/5
*@author: yichaoqun
*/
@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    StudentMapper studentMapper;

    @Override
    public Student checkLogin(String username, String password) {
        Student student = studentMapper.selectByUsername(username);
        if (student != null && student.getPassword().equals(password)) {
            return student;
        } else return null;
    }
}
