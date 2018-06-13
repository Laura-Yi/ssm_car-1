package com.sailing.web.controller.Student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*@description: 用于跳转页面的Controller
*@date: 12:46 2018/6/9
*@author: yichaoqun
*/

@RequestMapping("go")
@Controller
public class StudentGoController {
    @RequestMapping("/{view}")
    public String goTeacher(@PathVariable String view){
        return "student/"+view;
    }
}
