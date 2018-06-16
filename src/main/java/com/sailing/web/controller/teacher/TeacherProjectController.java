package com.sailing.web.controller.teacher;

import com.sailing.entity.*;
import com.sailing.service.ProjectcostService;
import com.sailing.service.ProjectmanagerService;
import com.sailing.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("teacherProject")
public class TeacherProjectController {

    @Resource
    StudentService studentService;

    @Resource
    ProjectmanagerService projectmanagerService;

    @Resource
    ProjectcostService projectcostService;


    private String path = "E:\\come_on\\managerFile";

    @RequestMapping("/{view}")
    public String goTeacher(@PathVariable String view){
        return "teacher/"+view;
    }

    @RequestMapping("/publish")
    public String publish(HttpSession session, @ModelAttribute Projectmanager projectmanager, Model model) throws IOException {
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        projectmanager.setTeacher(teacher.getId());
        projectmanager.setStatus("信息发布状态");
        projectmanager.setBuget(0);
        int result = projectmanagerService.insert(projectmanager);
        if (result > 0) {
            model.addAttribute("publicResult","发布成功");
        } else {
            model.addAttribute("publicResult","发布失败，请重新发布");
        }
        return "teacher/publishProject";
    }

    @RequestMapping("/show")
    public String show(HttpSession session,Model model){
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        List<Projectmanager> projectmanagerList = projectmanagerService.selectProjectmanagerByTeacher(teacher.getId());
        model.addAttribute("projectmanagerList",projectmanagerList);
        return "teacher/showProjectTopic";
    }

    @RequestMapping("/detail")
    public  String detail(HttpServletRequest request,Model model,HttpSession session){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        Projectmanager projectmanager = projectmanagerService.selectProjectmanagerById(projectId);
        model.addAttribute("projectmanager",projectmanager);
        model.addAttribute("teacher",teacher.getName());
        return "teacher/projectDetail";
    }

    @RequestMapping("/doDel")
    public String doDel(HttpServletRequest request){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        projectmanagerService.deleteProjectmanager(projectId);
        projectcostService.deleteProjectCostByProjectId(projectId);
        return "redirect:/teacherProject/show";
    }

    @RequestMapping("/addreviewResult")
    public String addreviewResult(String reviewResult,HttpServletRequest request){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        Projectmanager projectmanager = new Projectmanager();
        projectmanager.setId(projectId);
        projectmanager.setReviewresult(reviewResult);
        projectmanagerService.updateProject(projectmanager);
        return "redirect:/teacherProject/detail?projectId="+projectId;
    }


    @RequestMapping("/addProjectresult")
    public String addProjectresult(String projectresult,HttpServletRequest request){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        Projectmanager projectmanager = new Projectmanager();
        projectmanager.setId(projectId);
        projectmanager.setProjectresult(projectresult);
        projectmanagerService.updateProject(projectmanager);
        return "redirect:/teacherProject/detail?projectId="+projectId;
    }

    @RequestMapping("/costDetail")
    public String costDetail(HttpServletRequest request,Model model){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        List<Projectcost> projectcostList = projectcostService.selectprojectCostByProject(projectId);
        Projectmanager projectmanager = projectmanagerService.selectProjectmanagerById(projectId);
        int total = 0;
        for (Projectcost projectcost:projectcostList) {
            total = total + projectcost.getCost();
        }
        model.addAttribute("projectmanager",projectmanager);
        model.addAttribute("projectcostList",projectcostList);
        model.addAttribute("total",total);
        return "teacher/projectCostDetail";
    }

    @RequestMapping("addCost")
    public String addCost(HttpServletRequest request,Projectcost projectcost){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        projectcost.setProject(projectId);
        projectcostService.insert(projectcost);
        return "redirect:/teacherProject/costDetail?projectId="+projectId;
    }

    @RequestMapping("delProjectCost")
    public String delProjectCost(HttpServletRequest request){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        Integer projectCostId = Integer.parseInt(request.getParameter("projectCostId"));
        projectcostService.deleteProjectCost(projectCostId);
        return "redirect:/teacherProject/costDetail?projectId="+projectId;
    }

    @RequestMapping("/adduget")
    public String adduget(String buget,HttpServletRequest request){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        Projectmanager projectmanager = new Projectmanager();
        projectmanager.setId(projectId);
        projectmanager.setBuget(Integer.parseInt(buget));
        projectmanagerService.updateProject(projectmanager);
        return "redirect:/teacherProject/detail?projectId=" + projectId;
    }



}
