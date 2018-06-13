package com.sailing.web.controller.teacher;

import com.sailing.entity.Graduationmanager;
import com.sailing.entity.Student;
import com.sailing.entity.Teacher;
import com.sailing.service.GraduationmanagerService;
import com.sailing.service.StudentService;
import com.sailing.util.MyFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

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

    @Resource
    StudentService studentService;

    private String path = "E:\\come_on\\managerFile";

    @RequestMapping("/publish")
    public String publish(HttpSession session, @ModelAttribute Graduationmanager graduationmanager, Model model) throws IOException {
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        graduationmanager.setTeacher(teacher.getId());
        graduationmanager.setId(-1);
        int result = graduationmanagerService.insert(graduationmanager);
        if (result > 0) {
            model.addAttribute("publicResult","发布成功");
        } else {
            model.addAttribute("publicResult","发布失败，请重新发布");
        }
        return "teacher/publishGraTopic";
    }

    @RequestMapping("/show")
    public String show(HttpSession session,Model model){
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        List<Graduationmanager> graduationmanagerList = graduationmanagerService.selectGraduationmanagerByTeacher(teacher.getId());
        model.addAttribute("graduationmanagerList",graduationmanagerList);
        return "teacher/showGraTopic";
    }

    @RequestMapping("/detail")
    public  String detail(HttpServletRequest request,Model model,HttpSession session){
        Integer graduationId = Integer.parseInt(request.getParameter("graduationId"));
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        Graduationmanager graduationmanager = graduationmanagerService.selectGraduationmanagerById(graduationId);
        model.addAttribute("graduationmanager",graduationmanager);
        model.addAttribute("teacher",teacher.getName());
        if(graduationmanager.getStudent() != -1){
            Student student = studentService.selectStudentById(graduationmanager.getStudent());
            model.addAttribute("student",student.getName());
        }
        return "teacher/graduationDetail";
    }

    @RequestMapping("/result")
    public  String result(HttpServletRequest request,Model model,String resultform){
        Integer graduationId = Integer.parseInt(request.getParameter("graduationId"));
        Graduationmanager graduationmanager = new Graduationmanager();
        graduationmanager.setId(graduationId);
        graduationmanager.setResultform(resultform);
        graduationmanagerService.updateGraduationmanager(graduationmanager);
        return "redirect:/teacherGraduate/detail?graduationId="+graduationId;
    }

    @RequestMapping(value="/uploadfile/{fileType}")
    public String upload(MultipartFile file, HttpServletRequest request,@PathVariable String fileType,HttpSession session) throws IOException{
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
        }else if("评阅表".equals(fileType)){
            graduationmanager.setReviewform(location);
        }else if("评阅意见表".equals(fileType)){
            graduationmanager.setRevieweropinionform(location);
        }
        graduationmanagerService.updateGraduationmanager(graduationmanager);
        return "redirect:/teacherGraduate/detail?graduationId="+graduationId;
    }

    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/downfile/{fileType}")
    public void down(HttpServletRequest request,HttpServletResponse response,@PathVariable String fileType,String filePath) throws Exception{
        String graduationId = request.getParameter("graduationId");
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
        //假如以中文名下载的话
        String filename = MyFileUtil.getLastFile(filePath);
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }

}
