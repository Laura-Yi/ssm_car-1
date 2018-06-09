package com.sailing.web.controller.Student;

import com.sailing.entity.Student;
import com.sailing.service.StudentService;
import com.sailing.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
*@description: 学生登陆页面
*@date: 18:05 2018/6/5
*@author: yichaoqun
*/
@Controller
@RequestMapping("studentlogin")
public class StudentLoginController {

    @Resource
    StudentService studentService;

    //登录成功 进入管理页面
    @RequestMapping("/homepage")
    public String home(HttpServletRequest request) {

        return "student/homepage";
    }

    //登录验证
    @RequestMapping("/checklogin")
    @ResponseBody
    public String checkLogin(HttpSession session, HttpServletRequest request) throws IOException {
        Student student = studentService.checkLogin(request.getParameter("username"), MD5Util.encode2hex(request.getParameter("password")));
        if (student != null) {
            session.setAttribute("student",student);
            return "success";
        } else { return "fail";}
    }
}
