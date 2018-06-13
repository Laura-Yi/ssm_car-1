package com.sailing.service.impl;

import com.sailing.dao.StudentMapper;
import com.sailing.entity.Student;
import com.sailing.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Student selectStudentById(Integer studentId) {
        return studentMapper.selectByPrimaryKey(studentId);
    }

    @Override
    public List<Student> selectStudentByIds(List<Integer> studentIds) {
        return studentMapper.selectSrtpByStudentIds(studentIds);
    }


}
