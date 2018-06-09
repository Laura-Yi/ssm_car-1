package com.sailing.web.controller.teacher;

import com.sailing.entity.Graduationmanager;
import com.sailing.entity.Teacher;
import com.sailing.service.GraduationmanagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
*@description: 老师管理毕业设计
*@date: 11:57 2018/6/9
*@author: yichaoqun
*/
@Controller
@RequestMapping("teacherGraduate")
public class TeacherGraduationController {

    @Resource
    GraduationmanagerService graduationmanagerService;

    @RequestMapping("/publish")
    public String publish(HttpSession session, @ModelAttribute Graduationmanager graduationmanager, Model model) throws IOException {
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        graduationmanager.setTeacher(teacher.getId());
        int result = graduationmanagerService.insert(graduationmanager);
        if (result > 0) {
            model.addAttribute("publicResule","发布成功");
        } else {
            model.addAttribute("publicResule","发布失败，请重新发布");
        }
        return "teacher/publishGraTopic";
    }
}
