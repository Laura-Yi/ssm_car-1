package com.sailing.web.controller.other.TestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于测试的文件
 *
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
//    @Autowired
//    FavMapper favMapper;
//    @Autowired
//    CarInfoService carInfoService;
//    public favTest(){

//    }
//    @RequestMapping("/success")
//    public String showTest(){return "success";}
//    @RequestMapping("/buy")
//    public String showUserCenter(){
//        return "buy";
//    }
//    @RequestMapping("/showCar")
//    public ModelAndView showCarInfo() throws Exception {
//        //调用servie来查询商品列表
//        List<CarInfo> itemsList = carInfoService.selectCarInfoAll();
////        System.out.println("111111"+itemsList);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("itemsList", itemsList);
//        //指定逻辑视图名itemsList
//        modelAndView.setViewName("buy");
//
//        return modelAndView;
//    }

    @RequestMapping("/index")
    public String testX(){
        return "admin/test";
    }

    @RequestMapping("/home")
    public String testhome(){
        return "test/home1.1";
    }
//    @RequestMapping("/test2")
//    public String showDetail2(){
//        return "unfinished_order";
//    }
//    @RequestMapping("/test3")
//    public String showDetail3(){
//        return "updatepsw";
//    }
//
//    @RequestMapping("/test4")
//    public String showUserCenter2(){
//        return "usercenter";
//    }
//
//    @RequestMapping("/videotest")
//    public String videoTest(){
//        return "item/videotest";
//    }
//
//    @RequestMapping("/videoseek")
//    public void videoRang(@RequestHeader("Range")Integer range, HttpServletResponse response) throws IOException {
//        System.out.println("传输头Range："+range);
//        File file2=new File("");
//        System.out.println(file2.getAbsolutePath());
//        RandomAccessFile file=new RandomAccessFile("F:/videotest/test.flv","rw");
//        long length=file.length();
//        response.setContentType("video/x-flv");
//        response.setHeader("Cache-Control","max-age=600");
//        response.setHeader("Content-Length",(length-range)+"");
//        response.setHeader("Content-Range","bytes "+range+"-"+length+"");
//        response.setStatus(206);
//        OutputStream out=response.getOutputStream();
//        file.seek(88220953);
//        byte[] b = new byte[1024];
//        int nRead=0;
//        // 从输入流中读入字节流，然后写到文件中
//        while((nRead=file.read(b,0,1024)) > 0) {
//            out.write(b,0,nRead);
//        }
//    }

}
