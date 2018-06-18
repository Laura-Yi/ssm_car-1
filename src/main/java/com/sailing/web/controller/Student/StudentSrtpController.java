package com.sailing.web.controller.Student;

import com.sailing.entity.Srtpcost;
import com.sailing.entity.Srtpmanager;
import com.sailing.entity.Student;
import com.sailing.entity.Teacher;
import com.sailing.service.SrtpcostService;
import com.sailing.service.SrtpmanagerService;
import com.sailing.service.StudentService;
import com.sailing.service.TeacherService;
import com.sailing.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
*@description: 学生管理SRTP
*@date: 11:57 2018/6/9
*@author: yichaoqun
*/
@Controller
@RequestMapping("studentSrtp")
public class StudentSrtpController {

    @Resource
    SrtpmanagerService srtpmanagerService;

    @Resource
    StudentService studentService;

    @Resource
    SrtpcostService srtpcostService;

    @Resource
    TeacherService teacherService;


    private String path = "E:\\come_on\\managerFile";

    @RequestMapping("/select")
    public String toSelect(HttpSession session,Model model){
        Student student = (Student)session.getAttribute("student");
        Srtpmanager srtpmanager = srtpmanagerService.selectSrtpmanagerByStudent(student.getId().toString());
        if(srtpmanager != null && !"".equals(srtpmanager)){
            model.addAttribute("srtpmanager","selected");
        }else{
            List<Srtpmanager> srtpmanagerList = srtpmanagerService.selectALLSrtp();
            model.addAttribute("srtpmanagerList",srtpmanagerList);
            model.addAttribute("srtpmanager","unselected");
        }
        return "student/selectSRTPTopic";
    }


    @RequestMapping("/doSelect")
    public String show(HttpServletRequest request, Model model, HttpSession session){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        Student student = (Student)session.getAttribute("student");
        Srtpmanager srtpmanager = srtpmanagerService.selectSrtpById(srtpId);
        srtpmanager.setId(srtpId);
        srtpmanager.setStudent(srtpmanager.getStudent()+student.getId()+",");
        srtpmanagerService.updateSrtpManager(srtpmanager);
        model.addAttribute("srtpmanager","selected");
        return "student/selectSRTPTopic";
    }


    @RequestMapping("/detail")
    public  String detail(HttpServletRequest request, Model model, HttpSession session){
        Student student = (Student)session.getAttribute("student");
        Srtpmanager srtpmanager = srtpmanagerService.selectSrtpmanagerByStudent(student.getId().toString());
        if(srtpmanager != null && !"".equals(srtpmanager)){
            Teacher teacher = teacherService.selectTeacherById(srtpmanager.getTeacher());
            List<Integer> studentIds = StringUtil.StringToIntListByDou(srtpmanager.getStudent());
            List<Student> studentList = studentService.selectStudentByIds(studentIds);
            model.addAttribute("teacher",teacher);
            model.addAttribute("srtpmanager",srtpmanager);
            model.addAttribute("studentList",studentList);
            model.addAttribute("select","selected");
        }else{
            model.addAttribute("select","unselected");
        }
        return "student/srtpDetail";
    }

    @RequestMapping("costDetail")
    public String showCost(HttpServletRequest request,Model model){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        List<Srtpcost> srtpCostList = srtpcostService.selectSrtpCostBySrtpId(srtpId);
        Srtpmanager srtpmanager = srtpmanagerService.selectSrtpById(srtpId);
        int total = 0;
        for (Srtpcost srtpCost:srtpCostList) {
            total = total + srtpCost.getCost();
        }
        model.addAttribute("srtpmanager",srtpmanager);
        model.addAttribute("srtpCostList",srtpCostList);
        model.addAttribute("total",total);
        return "student/srtpCostDetail";
    }

    @RequestMapping("addCost")
    public String addCost(HttpServletRequest request,Srtpcost srtpcost){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        srtpcost.setSrtp(srtpId);
        srtpcostService.insert(srtpcost);
        return "redirect:/studentSrtp/costDetail?srtpId="+srtpId;
    }

    @RequestMapping("delSrtpCost")
    public String delSrtpCost(HttpServletRequest request){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        Integer srtpCostId = Integer.parseInt(request.getParameter("srtpCostId"));
        srtpcostService.delSrtpCostById(srtpCostId);
        return "redirect:/studentSrtp/costDetail?srtpId="+srtpId;
    }

    @RequestMapping("addYuSuan")
    public String addYuSuan(HttpServletRequest request,String YuSuan){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        Srtpmanager srtpmanager = new Srtpmanager();
        srtpmanager.setId(srtpId);
        srtpmanager.setCost(Integer.parseInt(YuSuan));
        srtpmanagerService.updateSrtpManager(srtpmanager);
        return "redirect:/studentSrtp/detail?srtpId="+srtpId;
    }



}
