package com.sailing.web.controller.Admin;

import com.sailing.entity.Admin;
import com.sailing.service.AdminService;
import com.sailing.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

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

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login-multi";
    }

    @RequestMapping("/register")
    public String load(HttpServletRequest request, Model model,String username,String upassword){
        Admin admin = adminService.selectAdminByUsername(username);
        if(admin != null){
            model.addAttribute("registerresult","用户名相同，请重新注册");
        }else{
            adminService.insert(username,MD5Util.encode2hex(upassword));
            model.addAttribute("registerresult","注册成功，请登陆");
        }
        return "login-multi";
    }
}
