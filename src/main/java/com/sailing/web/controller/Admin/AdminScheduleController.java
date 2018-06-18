package com.sailing.web.controller.Admin;

import com.sailing.entity.*;
import com.sailing.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*@description:管理员排课
*@date: 16:56 2018/6/16
*@author: yichaoqun
*/
@RequestMapping("adminSchedule")
@Controller
public class AdminScheduleController {

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

    @RequestMapping("/toPublicSchedule")
    public String toPublicSchedule(Model model){
        List<Teacher> teacherList = teacherService.selectAllTeacher();
        model.addAttribute("teacherList",teacherList);
        return "admin/publishCourse";
    }

    @RequestMapping("/publishSchedule")
    public String publishSchedule(Educationplan educationplan)
    {
        educationplanService.insert(educationplan);
        return "redirect:/adminSchedule/toPublicSchedule";
    }


    @RequestMapping("/toBuildClass")
    public String toBuildClass(Model model){
        List<Building> buildingList = buildingService.selectAllBuilding();
        List<Classroom> classroomList = classroomService.selectAllClassroom();
        model.addAttribute("buildingList",buildingList);
        model.addAttribute("classroomList",classroomList);
        return "admin/showClassBuild";
    }

    @RequestMapping("/addClassroom")
    public String addClassroom(Classroom classroom){
        classroomService.insert(classroom);
        schedulecourseService.insertByClassroom(classroom.getId());
        return "redirect:/adminSchedule/toBuildClass";
    }

    @RequestMapping("/addBuild")
    public String addBuild(Building building){
        buildingService.insert(building);
        return "redirect:/adminSchedule/toBuildClass";
    }


    @RequestMapping("/showUnselected")
    public String showUnselected(Model model,HttpServletRequest request){
        String addResult = request.getParameter("addResult");
        List<Educationplan> educationplanList = educationplanService.selectEducationplanUnselected();
        model.addAttribute("educationplanList",educationplanList);
        List<Classroom> classroomList = classroomService.selectAllClassroom();
        model.addAttribute("classroomList",classroomList);
        List<Teacher> teacherList = teacherService.selectAllTeacher();
        model.addAttribute("teacherList",teacherList);
        model.addAttribute("addResult",addResult);
        return "admin/showUnselectedCourse";
    }

    @RequestMapping("/addSchedulecourse")
    public String addSchedulecourse(Schedulecourse schedulecourse, String week, String daytime, HttpServletRequest request){
        String addResult = "";
        Integer educationplanId = Integer.parseInt(request.getParameter("educationplanId"));
        Schedulecourse schedulecourseNew = schedulecourseService.selectScheduleByClassAndTime(schedulecourse.getClassroom(),transferToNum(week,daytime));
        if("".equals(schedulecourseNew.getEducationplan()) || schedulecourseNew.getEducationplan() == null){
            schedulecourseService.updateScheduleByClassAndTime(educationplanId,schedulecourse.getClassroom(),transferToNum(week,daytime));
        }else{
            addResult = "您选择的这个时段已经被占用,请重新选择";
        }
        return "redirect:/adminSchedule/showUnselected?addResult="+addResult;
    }

    private Integer transferToNum(String week,String daytime){
        Integer weekNum = Integer.parseInt(week);
        Integer daytimeNum = Integer.parseInt(daytime);
        return (weekNum-1)*5+daytimeNum-1;
    }

    @RequestMapping("/autoArranging")
    public String autoArranging(HttpServletRequest request){
        String planList = request.getParameter("planList");
        List<Integer> educationIds = toEducationIds(planList);
        List<Integer> unScheduleIds = schedulecourseService.selectUnScheduleIds();
        List<Integer> locations = new ArrayList<Integer>();
        int unSelect = unScheduleIds.size();
        int location = 0;
        Schedulecourse schedulecourse = new Schedulecourse();
        for(Integer educationId:educationIds){
            location = (int)(Math.random() * (unSelect-1));
            while(locations.contains(location)){
                location = (int)(Math.random() * (unSelect-1));
            }
            locations.add(location);
            schedulecourse.setId(unScheduleIds.get(location));
            schedulecourse.setEducationplan(educationId);
            schedulecourseService.updateScheduleAuto(schedulecourse);
        }
        return "redirect:/adminSchedule/showUnselected";
    }

    private List<Integer> toEducationIds(String planList){
        String[] ids = planList.split("e");
        List<Integer> educationIds = new ArrayList<Integer>();
        for(String id:ids){
            educationIds.add(Integer.parseInt(id));
        }
        return educationIds;
    }

    @RequestMapping("/toClass")
    public String toClass(Model model){
        List<Classroom> classroomList = classroomService.selectAllClassroom();
        model.addAttribute("classroomList",classroomList);
        return "admin/showClass";
    }

    @RequestMapping("/showTimetable")
    public String showTimetable(Model model,HttpServletRequest request){
        Integer classroomId = Integer.parseInt(request.getParameter("classroomId"));
        List<Schedulecourse> schedulecourseList= schedulecourseService.selectScheduleByClassId(classroomId);
        List<Schedulecourse> schedulecourseList1 = new ArrayList<Schedulecourse>();
        List<Schedulecourse> schedulecourseList2 = new ArrayList<Schedulecourse>();
        List<Schedulecourse> schedulecourseList3 = new ArrayList<Schedulecourse>();
        List<Schedulecourse> schedulecourseList4 = new ArrayList<Schedulecourse>();
        List<Schedulecourse> schedulecourseList5 = new ArrayList<Schedulecourse>();
        for(int k = 0;k<25;k++){
            switch (k%5){
                case 0:schedulecourseList1.add(schedulecourseList.get(k));break;
                case 1:schedulecourseList2.add(schedulecourseList.get(k));break;
                case 2:schedulecourseList3.add(schedulecourseList.get(k));break;
                case 3:schedulecourseList4.add(schedulecourseList.get(k));break;
                case 4:schedulecourseList5.add(schedulecourseList.get(k));break;
            }
        }
       /* switch ()
        int i=0;
        for(;i<5;i++){
            schedulecourseList1.add(schedulecourseList.get(i));
        }
        for(;i<10;i++){
            schedulecourseList2.add(schedulecourseList.get(i));
        }
        for(;i<15;i++){
            schedulecourseList3.add(schedulecourseList.get(i));
        }
        for(;i<20;i++){
            schedulecourseList4.add(schedulecourseList.get(i));
        }
        for(;i<25;i++){
            schedulecourseList5.add(schedulecourseList.get(i));
        }*/
        Map<String,List<Schedulecourse>> schedulecourseMap = new HashMap<String,List<Schedulecourse>>();
        schedulecourseMap.put("1",schedulecourseList1);
        schedulecourseMap.put("2",schedulecourseList2);
        schedulecourseMap.put("3",schedulecourseList3);
        schedulecourseMap.put("4",schedulecourseList4);
        schedulecourseMap.put("5",schedulecourseList5);
        model.addAttribute("schedulecourseList1",schedulecourseList1);
        model.addAttribute("schedulecourseList2",schedulecourseList2);
        model.addAttribute("schedulecourseList3",schedulecourseList3);
        model.addAttribute("schedulecourseList4",schedulecourseList4);
        model.addAttribute("schedulecourseList5",schedulecourseList5);
        model.addAttribute("schedulecourseMap",schedulecourseMap);
        return "admin/showTimetableDetail";
    }

}
