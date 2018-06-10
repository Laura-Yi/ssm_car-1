package com.sailing.web.controller.Admin;

import com.sailing.entity.Graduationmanager;
import com.sailing.entity.Student;
import com.sailing.entity.Teacher;
import com.sailing.service.GraduationmanagerService;
import com.sailing.service.StudentService;
import com.sailing.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
*@description: 老师管理毕业设计
*@date: 11:57 2018/6/9
*@author: yichaoqun
*/
@Controller
@RequestMapping("adminGraduate")
public class AdminGraduationController {

    @Resource
    GraduationmanagerService graduationmanagerService;

    @Resource
    StudentService studentService;

    @Resource
    TeacherService teacherService;


    @RequestMapping("/show")
    public String show(HttpSession session,Model model){
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        List<Graduationmanager> graduationmanagerList = graduationmanagerService.selectAllGraduationmanager();
        model.addAttribute("graduationmanagerList",graduationmanagerList);
        return "admin/showGraTopic";
    }

    @RequestMapping("/detail")
    public  String detail(HttpServletRequest request,Model model,HttpSession session){
        Integer graduationId = Integer.parseInt(request.getParameter("graduationId"));
        Graduationmanager graduationmanager = graduationmanagerService.selectGraduationmanagerById(graduationId);
        Teacher teacher = teacherService.selectTeacherById(graduationmanager.getTeacher());
        model.addAttribute("graduationmanager",graduationmanager);
        model.addAttribute("teacher",teacher.getName());
        if(graduationmanager.getStudent() != -1){
            Student student = studentService.selectStudentById(graduationmanager.getStudent());
            model.addAttribute("student",student.getName());
        }
        return "admin/graduationDetail";
    }

}
