package com.sailing.web.controller.Admin;

import com.sailing.entity.Admin;
import com.sailing.service.AdminService;
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
@RequestMapping("adminLogin")
public class AdminLoginController {

    @Resource
    AdminService adminService;

    //登录成功 进入小秘管理页面
    @RequestMapping("/homepage")
    public String home(HttpServletRequest request) {

        return "admin/homepage";
    }

    //登录验证
    @RequestMapping("/checklogin")
    @ResponseBody
    public String checkLogin(HttpSession session, HttpServletRequest request) throws IOException {
        Admin admin = adminService.checkLogin(request.getParameter("username"), MD5Util.encode2hex(request.getParameter("password")));
        if (admin != null) {
            session.setAttribute("admin",admin);
            return "success";
        } else { return "fail";}
    }
}
