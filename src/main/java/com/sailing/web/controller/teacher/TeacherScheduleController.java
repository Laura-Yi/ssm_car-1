package com.sailing.web.controller.teacher;

import com.sailing.entity.Educationplan;
import com.sailing.entity.Teacher;
import com.sailing.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
*@description:管理员排课
*@date: 16:56 2018/6/16
*@author: yichaoqun
*/
@RequestMapping("teacherSchedule")
@Controller
public class TeacherScheduleController {

    @Resource
    BuildingService buildingService;

    @Resource
    ClassroomService classroomService;

    @Resource
    SchedulecourseService schedulecourseService;

    @Resource
    TeacherService teacherService;

    @Resource
    EducationplanService educationplanService;



    @RequestMapping("/showCourseByTeacher")
    public String showUnselected(Model model, HttpServletRequest request, HttpSession session){
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        List<Educationplan> educationplanList = educationplanService.selectEducationplanByTeacher(teacher.getId());
        model.addAttribute("educationplanList",educationplanList);
        return "/teacher/showTeacherCourse";
    }



}
