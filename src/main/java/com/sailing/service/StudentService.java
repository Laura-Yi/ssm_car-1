package com.sailing.service;

import com.sailing.entity.Student;

/**
*@description: Service For Student
*@date: 18:17 2018/6/5
*@author: yichaoqun
*/
public interface StudentService {
    /**
     * 验证学生登陆
     * @param username
     * @param password
     * @return
     */
    public Student checkLogin(String username, String password);
}
