package com.sailing.web.controller.teacher;

import com.sailing.entity.Classroom;
import com.sailing.entity.Educationplan;
import com.sailing.entity.Schedulecourse;
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

    @RequestMapping("/addRequest")
    public String addRequest(HttpServletRequest request,Educationplan educationplan){
        Integer educationplanId = Integer.parseInt(request.getParameter("educationplanId"));
        educationplan.setId(educationplanId);
        educationplanService.update(educationplan);
        return "redirect:/teacherSchedule/showCourseByTeacher";
    }

    @RequestMapping("/showCourseDetail")
    public String showCourseDetail(HttpServletRequest request,Model model,HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        Integer educationplanId = Integer.parseInt(request.getParameter("educationplanId"));
        Educationplan educationplan = educationplanService.selectEducationplanById(educationplanId);
        Schedulecourse schedulecourse = schedulecourseService.selectScheduleByeducationId(educationplanId);
        Classroom classroom = classroomService.selectClassroomById(schedulecourse.getClassroom());
        int time = schedulecourse.getTime();
        int week = time/5+1;
        int timedetail = time%5 +1;
        String timeDE = "星期"+week+"第"+timedetail+"节课";
        model.addAttribute("timeDE",timeDE);
        model.addAttribute("schedulecourse",schedulecourse);
        model.addAttribute("teacher",teacher);
        model.addAttribute("classroom",classroom);
        model.addAttribute("educationplan",educationplan);
        return "/teacher/courseDatail";

    }



}
