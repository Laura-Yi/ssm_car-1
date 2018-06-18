package com.sailing.service.impl;

import com.sailing.dao.EducationplanMapper;
import com.sailing.entity.Educationplan;
import com.sailing.service.EducationplanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*@description:EducationplanServiceImpl
*@date: 19:10 2018/6/16
*@author: yichaoqun
*/
@Service
public class EducationplanServiceImpl implements EducationplanService{

    @Resource
    EducationplanMapper educationplanMapper;

    @Override
    public int insert(Educationplan educationplan) {
        educationplanMapper.insertSelective(educationplan);
        return educationplan.getId();
    }

    @Override
    public List<Educationplan> selectEducationplanUnselected() {
        return educationplanMapper.selectEducationplanUnselected();
    }

    @Override
    public Educationplan selectEducationplanById(Integer educationplanId) {
        return educationplanMapper.selectByPrimaryKey(educationplanId);
    }

    @Override
    public List<Educationplan> selectEducationplanByTeacher(Integer teacher) {
        return educationplanMapper.selectEducationplanByTeacher(teacher);
    }

    @Override
    public void update(Educationplan educationplan) {
        educationplanMapper.updateByPrimaryKeySelective(educationplan);
    }
}
