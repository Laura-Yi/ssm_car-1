package com.sailing.service;

import com.sailing.entity.Graduationmanager;

/**
*@description: 毕业论文模块Service
*@date: 12:15 2018/6/9
*@author: yichaoqun
*/
public interface GraduationmanagerService {
    /**
     * 添加论文模块
     * @param graduationmanager
     * @return
     */
    public int insert(Graduationmanager graduationmanager);
}
