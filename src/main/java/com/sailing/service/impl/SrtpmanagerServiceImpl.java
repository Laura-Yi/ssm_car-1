package com.sailing.service.impl;

import com.sailing.dao.SrtpmanagerMapper;
import com.sailing.entity.Srtpmanager;
import com.sailing.service.SrtpmanagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*@description: Service For STRP
*@date: 10:41 2018/6/11
*@author: yichaoqun
*/
@Service
public class SrtpmanagerServiceImpl implements SrtpmanagerService{

    @Resource
    SrtpmanagerMapper srtpmanagerMapper;

    @Override
    public int insert(Srtpmanager srtpmanager) {
        srtpmanagerMapper.insertSelective(srtpmanager);
        return srtpmanager.getId();
    }

    @Override
    public List<Srtpmanager> selectSrtpByTeacher(Integer teacherId) {
        return srtpmanagerMapper.selectSrtpByTeacher(teacherId);
    }

    @Override
    public Srtpmanager selectSrtpById(Integer srtpId) {
        return srtpmanagerMapper.selectByPrimaryKey(srtpId);
    }

    @Override
    public int deleteSrtpById(Integer srtpId) {
        return srtpmanagerMapper.deleteByPrimaryKey(srtpId);
    }

    @Override
    public void updateSrtpManager(Srtpmanager srtpmanager) {
        srtpmanagerMapper.updateByPrimaryKeySelective(srtpmanager);
    }

    @Override
    public Srtpmanager selectSrtpmanagerByStudent(String studentId) {
        studentId = studentId+",";
        return srtpmanagerMapper.selectSrtpmanagerByStudent(studentId);
    }

    @Override
    public List<Srtpmanager> selecSrtpmanagerUnselected() {
        return srtpmanagerMapper.selecSrtpmanagerUnselected();
    }

    @Override
    public List<Srtpmanager> selectALLSrtp() {
        return srtpmanagerMapper.selectALLSrtp();
    }

}
