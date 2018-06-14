package com.sailing.web.controller.teacher;

import com.sailing.entity.Srtpcost;
import com.sailing.entity.Srtpmanager;
import com.sailing.entity.Student;
import com.sailing.entity.Teacher;
import com.sailing.service.SrtpcostService;
import com.sailing.service.SrtpmanagerService;
import com.sailing.service.StudentService;
import com.sailing.util.MyFileUtil;
import com.sailing.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("teacherSrtp")
public class TeacherSrtpController {

    @Resource
    SrtpmanagerService srtpmanagerService;

    @Resource
    StudentService studentService;

    @Resource
    SrtpcostService srtpcostService;


    private String path = "E:\\come_on\\managerFile";

    @RequestMapping("/publish")
    public String publish(HttpSession session,Model model,Srtpmanager srtpmanager) throws IOException {
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        srtpmanager.setTeacher(teacher.getId());
        srtpmanager.setStudent("0");
        srtpmanager.setStatus("立项状态");
        int result = srtpmanagerService.insert(srtpmanager);
        if (result > 0) {
            model.addAttribute("publicResult","发布成功");
        } else {
            model.addAttribute("publicResult","发布失败，请重新发布");
        }
        return "teacher/publishSrtp";
    }

    @RequestMapping("/show")
    public String show(HttpSession session,Model model){
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        List<Srtpmanager> srtpmanagerList = srtpmanagerService.selectSrtpByTeacher(teacher.getId());
        model.addAttribute("srtpmanagerList",srtpmanagerList);
        return "teacher/showSrtpTopic";
    }

    @RequestMapping("/detail")
    public  String detail(HttpServletRequest request, Model model, HttpSession session){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        model.addAttribute("teacher",teacher.getName());
        Srtpmanager srtpmanager = srtpmanagerService.selectSrtpById(srtpId);
        model.addAttribute("srtpmanager",srtpmanager);
        if(srtpmanager.getStudent() != null && !"".equals(srtpmanager.getStudent())){
            List<Integer> studentIds = StringUtil.StringToIntListByDou(srtpmanager.getStudent());
            List<Student> studentList = studentService.selectStudentByIds(studentIds);
            model.addAttribute("studentList",studentList);
        }
        return "teacher/srtpDetail";
    }

    @RequestMapping("doDel")
    public String delSrtp(HttpServletRequest request){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        Srtpmanager srtpmanager = srtpmanagerService.selectSrtpById(srtpId);
        srtpcostService.delSrtpCostBySrtpId(srtpId);
        srtpmanagerService.deleteSrtpById(srtpId);
        return "redirect:/teacherSrtp/show";
    }

    @RequestMapping("costDetail")
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
        return "teacher/srtpCostDetail";
    }

    @RequestMapping("addCost")
    public String addCost(HttpServletRequest request,Srtpcost srtpcost){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        srtpcost.setSrtp(srtpId);
        srtpcostService.insert(srtpcost);
        return "redirect:/teacherSrtp/costDetail?srtpId="+srtpId;
    }

    @RequestMapping("delSrtpCost")
    public String delSrtpCost(HttpServletRequest request){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        Integer srtpCostId = Integer.parseInt(request.getParameter("srtpCostId"));
        srtpcostService.delSrtpCostById(srtpCostId);
        return "redirect:/teacherSrtp/costDetail?srtpId="+srtpId;
    }

    @RequestMapping(value="/uploadfile/{fileType}")
    public String upload(MultipartFile file, HttpServletRequest request, @PathVariable String fileType, HttpSession session) throws IOException{
        String srtpId = request.getParameter("srtpId");
        String fileName = fileType+ MyFileUtil.getExtention(file.getOriginalFilename());
        String filePath = path+"\\graduation\\gra"+srtpId;
        File dir = new File(filePath,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        Srtpmanager srtpmanager = new Srtpmanager();
        srtpmanager.setId(Integer.parseInt(srtpId));
        String location = filePath+"\\"+fileName;

        if("SRTP申请表".equals(fileType)){
            srtpmanager.setApllication(location);
        }else if("SRTP结题验收表".equals(fileType)){
            srtpmanager.setComplete(location);
        }else if("SRTP中期检查表".equals(fileType)){
            srtpmanager.setMidcheck(location);
        }
        srtpmanagerService.updateSrtpManager(srtpmanager);
        return "redirect:/teacherSrtp/detail?srtpId="+srtpId;
    }

    @RequestMapping("addYuSuan")
    public String addYuSuan(HttpServletRequest request,String YuSuan){
        Integer srtpId = Integer.parseInt(request.getParameter("srtpId"));
        Srtpmanager srtpmanager = new Srtpmanager();
        srtpmanager.setId(srtpId);
        srtpmanager.setCost(Integer.parseInt(YuSuan));
        srtpmanagerService.updateSrtpManager(srtpmanager);
        return "redirect:/teacherSrtp/detail?srtpId="+srtpId;
    }


    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/downfile/{fileType}")
    public void down(HttpServletRequest request, HttpServletResponse response, @PathVariable String fileType, String filePath) throws Exception{
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
