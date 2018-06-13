package com.sailing.web.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*@description: 用于跳转页面的Controller
*@date: 12:46 2018/6/9
*@author: yichaoqun
*/

@RequestMapping("goTeacher")
@Controller
public class TeacherGoController {
    @RequestMapping("/{view}")
    public String goTeacher(@PathVariable String view){
        return "teacher/"+view;
    }
}
