package com.sailing.web.controller.teacher;

import com.sailing.entity.Teacher;
import com.sailing.service.TeacherService;
import com.sailing.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
*@description: 管理员登陆页面
*@date: 18:05 2018/6/5
*@author: yichaoqun
*/
@Controller
@RequestMapping("teacherLogin")
public class TeacherLoginController {

    @Resource
    TeacherService teacherService;

    //登录成功 进入小秘管理页面
    @RequestMapping("/homepage")
    public String home(HttpServletRequest request) {

        return "teacher/homepage";
    }

    //登录验证
    @RequestMapping("/checklogin")
    @ResponseBody
    public String checkLogin(HttpSession session, HttpServletRequest request) throws IOException {
        Teacher teacher = teacherService.checkLogin(request.getParameter("username"), MD5Util.encode2hex(request.getParameter("password")));
        if (teacher != null) {
            session.setAttribute("teacher",teacher);
            return "success";

        } else { return "fail";}
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login-multi";
    }

}
