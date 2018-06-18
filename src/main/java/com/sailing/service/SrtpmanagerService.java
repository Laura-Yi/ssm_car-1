package com.sailing.service;

import com.sailing.entity.Srtpmanager;

import java.util.List;

/**
*@description: Service For STRP
*@date: 10:41 2018/6/11
*@author: yichaoqun
*/
public interface SrtpmanagerService {

    int insert(Srtpmanager srtpmanager);

    List<Srtpmanager> selectSrtpByTeacher(Integer teacherId);

    Srtpmanager selectSrtpById(Integer srtpId);

    int deleteSrtpById(Integer srtpId);

    void updateSrtpManager(Srtpmanager srtpmanager);

    Srtpmanager selectSrtpmanagerByStudent(String id);

    List<Srtpmanager> selecSrtpmanagerUnselected();

    List<Srtpmanager> selectALLSrtp();
}

