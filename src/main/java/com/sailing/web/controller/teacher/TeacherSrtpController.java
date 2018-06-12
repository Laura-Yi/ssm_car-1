package com.sailing.web.controller.teacher;

import com.sailing.entity.Srtpmanager;
import com.sailing.entity.Student;
import com.sailing.entity.Teacher;
import com.sailing.service.SrtpmanagerService;
import com.sailing.service.StudentService;
import com.sailing.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
*@description: 老师管理毕业设计
*@date: 11:57 2018/6/9
*@author: yichaoqun
*/
@Controller
@RequestMapping("teacherSrtp")
public class TeacherSrtpController {

    @Resource
    SrtpmanagerService srtpmanagerService;

    @Resource
    StudentService studentService;

    private String path = "E:\\come_on\\managerFile";

    @RequestMapping("/publish")
    public String publish(HttpSession session,Model model,Srtpmanager srtpmanager) throws IOException {
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        srtpmanager.setTeacher(teacher.getId());
        srtpmanager.setStudent("0");
        int result = srtpmanagerService.insert(srtpmanager);
        if (result > 0) {
            model.addAttribute("publicResult","发布成功");
        } else {
            model.addAttribute("publicResult","发布失败，请重新发布");
        }
        return "teacher/publishSrtp";
    }

    @RequestMapping("/show")
    public String show(HttpSession session,Model model){
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        List<Srtpmanager> srtpmanagerList = srtpmanagerService.selectSrtpByTeacher(teacher.getId());
        model.addAttribute("srtpmanagerList",srtpmanagerList);
        return "teacher/showSrtpTopic";
    }

    @RequestMapping("/detail")
    public  String detail(HttpServletRequest request, Model model, HttpSession session){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        model.addAttribute("teacher",teacher.getName());
        Srtpmanager srtpmanager = srtpmanagerService.selectSrtpById(srtpId);
        model.addAttribute("srtpmanager",srtpmanager);
        if(!"0".equals(srtpmanager.getStudent())){
            List<Integer> studentIds = StringUtil.StringToIntList(srtpmanager.getStudent());
            List<Student> studentList = studentService.selectStudentByIds(studentIds);
            model.addAttribute("studentList",studentList);
        }
        return "teacher/graduationDetail";
    }

    @RequestMapping("doDel")
    public String delSrtp(HttpServletRequest request){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        srtpmanagerService.deleteSrtpById(srtpId);
        return "redirect:/teacherSrtp/show";
    }

}
