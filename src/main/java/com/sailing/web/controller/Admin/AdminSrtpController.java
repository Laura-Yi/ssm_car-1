package com.sailing.web.controller.Admin;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
*@description: 管理员管理srtp
*@date: 11:57 2018/6/9
*@author: yichaoqun
*/
@Controller
@RequestMapping("adminSrtp")
public class AdminSrtpController {

    @Resource
    SrtpmanagerService srtpmanagerService;

    @Resource
    StudentService studentService;

    @Resource
    TeacherService teacherService;

    @Resource
    SrtpcostService srtpcostService;

    @RequestMapping("/show")
    public String show(HttpSession session, Model model){
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        List<Srtpmanager> srtpmanagerList = srtpmanagerService.selectALLSrtp();
        model.addAttribute("srtpmanagerList",srtpmanagerList);
        return "admin/showSrtpTopic";
    }

    @RequestMapping("/detail")
    public  String detail(HttpServletRequest request, Model model, HttpSession session){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        Srtpmanager srtpmanager = srtpmanagerService.selectSrtpById(srtpId);
        model.addAttribute("srtpmanager",srtpmanager);
        Teacher teacher = teacherService.selectTeacherById(srtpmanager.getTeacher());
        model.addAttribute("teacher",teacher.getName());
        if(srtpmanager.getStudent() != null && !"".equals(srtpmanager.getStudent())){
            List<Integer> studentIds = StringUtil.StringToIntListByDou(srtpmanager.getStudent());
            List<Student> studentList = studentService.selectStudentByIds(studentIds);
            model.addAttribute("studentList",studentList);
        }
        return "admin/srtpDetail";
    }

    @RequestMapping("/costDetail")
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
        return "admin/srtpCostDetail";
    }

    @RequestMapping("/nextStatus/{status}")
    public String nextStatus(@PathVariable String status,HttpServletRequest request){
        Srtpmanager srtpmanager = new Srtpmanager();
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        srtpmanager.setId(srtpId);
        if("立项状态".equals(status)){
            srtpmanager.setStatus("中期答辩状态");
        }else if("中期答辩状态".equals(status)){
            srtpmanager.setStatus("验收状态");
        }else if("验收状态".equals(status)){
            srtpmanager.setStatus("验收状态");
        }
        srtpmanagerService.updateSrtpManager(srtpmanager);
        return "redirect:/adminSrtp/detail?srtpId="+srtpId;
    }

    @RequestMapping("/doDel")
    public String delSrtp(HttpServletRequest request){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        Srtpmanager srtpmanager = srtpmanagerService.selectSrtpById(srtpId);
        srtpcostService.delSrtpCostBySrtpId(srtpId);
        srtpmanagerService.deleteSrtpById(srtpId);
        return "redirect:/adminSrtp/show";
    }
}
