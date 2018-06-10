package com.sailing.service;

import com.sailing.entity.Teacher;

/**
*@description: Service For Teacher
*@date: 18:17 2018/6/5
*@author: yichaoqun
*/
public interface TeacherService {
    /**
     * 验证教师登陆
     * @param username
     * @param password
     * @return
     */
    public Teacher checkLogin(String username, String password);

    Teacher selectTeacherById(Integer teacher);
}
