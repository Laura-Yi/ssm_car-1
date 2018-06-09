package com.sailing.service.impl;

import com.sailing.dao.GraduationmanagerMapper;
import com.sailing.entity.Graduationmanager;
import com.sailing.service.GraduationmanagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
*@description:毕业论文模块
*@date: 12:19 2018/6/9
*@author: yichaoqun
*/
@Service
public class GraduationmanagerServiceImpl implements GraduationmanagerService {

    @Resource
    GraduationmanagerMapper graduationmanagerMapper;

    @Override
    public int insert(Graduationmanager graduationmanager) {
        graduationmanagerMapper.insertSelective(graduationmanager);
        return graduationmanager.getId();
    }
}
