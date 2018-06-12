package com.sailing.util;

import java.util.ArrayList;
import java.util.List;

/**
*@description: 一些字符操作工具类
*@date: 11:29 2018/6/11
*@author: yichaoqun
*/
public class StringUtil {
    public static List<Integer> StringToIntList(String digit){
        char[] charList = digit.toCharArray();
        List<Integer> numList = new ArrayList<Integer>();
        for(char num:charList){
            numList.add((int)num);
        }
        return numList;
    }
}
