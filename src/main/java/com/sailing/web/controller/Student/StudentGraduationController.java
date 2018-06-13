package com.sailing.web.controller.Student;

import com.sailing.entity.Graduationmanager;
import com.sailing.entity.Student;
import com.sailing.entity.Teacher;
import com.sailing.service.GraduationmanagerService;
import com.sailing.service.TeacherService;
import com.sailing.util.MyFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
*@description: 老师管理毕业设计
*@date: 11:57 2018/6/9
*@author: yichaoqun
*/
@Controller
@RequestMapping("studentGraduate")
public class StudentGraduationController {

    @Resource
    GraduationmanagerService graduationmanagerService;

    @Resource
    TeacherService teacherService;

    private String path = "E:\\come_on\\managerFile";


    @RequestMapping("/select")
    public String show(HttpSession session,Model model){
        Student student = (Student)session.getAttribute("student");
        Graduationmanager graduationmanager = graduationmanagerService.selectGraduationmanagerByStudent(student.getId());
       if(graduationmanager != null && !"".equals(graduationmanager)){
            model.addAttribute("graduationmanager","selected");
        }else{
            List<Graduationmanager> graduationmanagerList = graduationmanagerService.selectGraduationmanagerUnselected();
            model.addAttribute("graduationmanagerList",graduationmanagerList);
            model.addAttribute("graduationmanager","unselected");
        }
        return "student/selectGraTopic";
    }

    @RequestMapping("/doSelect")
    public String show(HttpServletRequest request, Model model,HttpSession session){
        Integer graduationId = Integer.parseInt(request.getParameter("graduationId"));
        Student student = (Student)session.getAttribute("student");
        Graduationmanager graduationmanager = new Graduationmanager();
        graduationmanager.setId(graduationId);
        graduationmanager.setStudent(student.getId());
        graduationmanagerService.updateGraduationmanager(graduationmanager);
        model.addAttribute("graduationmanager","selected");
        return "student/selectGraTopic";
    }

    @RequestMapping("/detail")
    public  String detail(HttpSession session,Model model){
        Student student = (Student)session.getAttribute("student");
        Graduationmanager graduationmanager = graduationmanagerService.selectGraduationmanagerByStudent(student.getId());
        if(graduationmanager != null && !"".equals(graduationmanager)){
            model.addAttribute("graduationmanager",graduationmanager);
            model.addAttribute("student",student.getName());
            Teacher teacher = teacherService.selectTeacherById(graduationmanager.getTeacher());
            model.addAttribute("teacher",teacher.getName());
        }else{
            model.addAttribute("graduationmanager","unselected");
        }
        return "student/graduationDetail";
    }


    @RequestMapping(value="/uploadfile/{fileType}")
    public String upload(MultipartFile file, HttpServletRequest request, @PathVariable String fileType, HttpSession session) throws IOException{
        String graduationId = request.getParameter("graduationId");
        //String fileName = file.getOriginalFilename();
        String fileName = fileType+ MyFileUtil.getExtention(file.getOriginalFilename());
        String filePath = path+"\\graduation\\gra"+graduationId;
        File dir = new File(filePath,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        Graduationmanager graduationmanager = new Graduationmanager();
        graduationmanager.setId(Integer.parseInt(graduationId));
        String location = filePath+"\\"+fileName;

        if("任务书".equals(fileType)){
            graduationmanager.setBookassign(location);
        }else if("选题报告".equals(fileType)){
            graduationmanager.setTopicselectionreport(location);
        }else if("中期考核表".equals(fileType)){
            graduationmanager.setMidcheck(location);
        }else if("毕业论文".equals(fileType)){
            graduationmanager.setGraduationstudy(location);
        }else if("评阅表".equals(fileType)){
            graduationmanager.setReviewform(location);
        }else if("评阅意见表".equals(fileType)){
            graduationmanager.setRevieweropinionform(location);
        }
        graduationmanagerService.updateGraduationmanager(graduationmanager);
        return "redirect:/studentGraduate/detail";
    }

}
