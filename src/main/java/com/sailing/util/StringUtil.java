package com.sailing.util;

import java.util.ArrayList;
import java.util.List;

/**
*@description: 一些字符操作工具类
*@date: 11:29 2018/6/11
*@author: yichaoqun
*/
public class StringUtil {
    public static List<Integer> StringToIntListByDou(String student) {
        String[] charList = student.split(",");
        List<Integer> numList = new ArrayList<Integer>();
        for(String num:charList){
            numList.add(Integer.parseInt(num));
        }
        return numList;
    }
}
