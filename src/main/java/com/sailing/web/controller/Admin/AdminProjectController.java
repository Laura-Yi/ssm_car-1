package com.sailing.web.controller.Admin;

import com.sailing.entity.Projectcost;
import com.sailing.entity.Projectmanager;
import com.sailing.entity.Teacher;
import com.sailing.service.ProjectcostService;
import com.sailing.service.ProjectmanagerService;
import com.sailing.service.StudentService;
import com.sailing.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("adminProject")
public class AdminProjectController {

    @Resource
    StudentService studentService;

    @Resource
    TeacherService teacherService;

    @Resource
    ProjectmanagerService projectmanagerService;

    @Resource
    ProjectcostService projectcostService;


    private String path = "E:\\come_on\\managerFile";


    @RequestMapping("/show")
    public String show(Model model){
        List<Projectmanager> projectmanagerList = projectmanagerService.selectAllProjectmanager();
        model.addAttribute("projectmanagerList",projectmanagerList);
        return "admin/showProjectTopic";
    }

    @RequestMapping("/detail")
    public  String detail(HttpServletRequest request,Model model,HttpSession session){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        Projectmanager projectmanager = projectmanagerService.selectProjectmanagerById(projectId);
        Teacher teacher = teacherService.selectTeacherById(projectmanager.getTeacher());
        model.addAttribute("projectmanager",projectmanager);
        model.addAttribute("teacher",teacher.getName());
        return "admin/projectDetail";
    }

    @RequestMapping("/doDel")
    public String doDel(HttpServletRequest request){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        projectmanagerService.deleteProjectmanager(projectId);
        projectcostService.deleteProjectCostByProjectId(projectId);
        return "redirect:/adminProject/show";
    }

    @RequestMapping("/addreviewResult")
    public String addreviewResult(String reviewResult,HttpServletRequest request){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        Projectmanager projectmanager = new Projectmanager();
        projectmanager.setId(projectId);
        projectmanager.setReviewresult(reviewResult);
        projectmanagerService.updateProject(projectmanager);
        return "redirect:/adminProject/detail?projectId="+projectId;
    }


    @RequestMapping("/addProjectresult")
    public String addProjectresult(String projectresult,HttpServletRequest request){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        Projectmanager projectmanager = new Projectmanager();
        projectmanager.setId(projectId);
        projectmanager.setProjectresult(projectresult);
        projectmanagerService.updateProject(projectmanager);
        return "redirect:/adminProject/detail?projectId="+projectId;
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
        return "admin/projectCostDetail";
    }

    @RequestMapping("addCost")
    public String addCost(HttpServletRequest request,Projectcost projectcost){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        projectcost.setProject(projectId);
        projectcostService.insert(projectcost);
        return "redirect:/adminProject/costDetail?projectId="+projectId;
    }

    @RequestMapping("delProjectCost")
    public String delProjectCost(HttpServletRequest request){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        Integer projectCostId = Integer.parseInt(request.getParameter("projectCostId"));
        projectcostService.deleteProjectCost(projectCostId);
        return "redirect:/adminProject/costDetail?projectId="+projectId;
    }

    @RequestMapping("/adduget")
    public String adduget(String buget,HttpServletRequest request){
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        Projectmanager projectmanager = new Projectmanager();
        projectmanager.setId(projectId);
        projectmanager.setBuget(Integer.parseInt(buget));
        projectmanagerService.updateProject(projectmanager);
        return "redirect:/adminProject/detail?projectId=" + projectId;
    }

    @RequestMapping("/nextStatus/{status}")
    public String nextStatus(@PathVariable String status, HttpServletRequest request){
        Projectmanager projectmanager = new Projectmanager();
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        projectmanager.setId(projectId);
        if("信息发布状态".equals(status)){
            projectmanager.setStatus("评选结果状态");
        }else if("评选结果状态".equals(status)){
            projectmanager.setStatus("中期检查状态");
        }else if("中期检查状态".equals(status)){
            projectmanager.setStatus("结题验收状态");
        }else if("结题验收状态".equals(status)){
            projectmanager.setStatus("结题验收状态");
        }
        projectmanagerService.updateProject(projectmanager);
        return "redirect:/adminProject/detail?projectId="+projectId;
    }



}
