package com.sailing.service;

import com.sailing.dao.UserMapper;
import com.sailing.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        User user1 = userService.selectByPrimaryKey("36331");
        System.out.println("u11111:"+user1.toString());
        User user2 = userMapper.selectByPrimaryKey("36331");
        System.out.println("u2:"+user2.toString());
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }


    @Test
    public void testFile() {
//      举例：
        String fName =" G:\\Java_Source\\navigation_tigra_menu\\demo1\\img\\lev1_arrow.gif ";

//      方法一：

        File tempFile =new File( fName.trim());

        String fileName = tempFile.getName();

        System.out.println("fileName = " + fileName);

//      方法二：

        String fName2 = fName.trim();

        String fileName2= fName.substring(fName2.lastIndexOf("/")+1);
        //或者
        String fileName4 = fName2.substring(fName2.lastIndexOf("\\")+1);

        System.out.println("fileName = " + fileName2);
        System.out.println("fileName = " + fileName4);

//      方法三：

        String fName3 = fName.trim();

        String temp[] = fName3.split("\\\\"); /**split里面必须是正则表达式，"\\"的作用是对字符串转义*/

        String fileName3 = temp[temp.length-1];

        System.out.println("fileName = " + fileName3);

        }


}