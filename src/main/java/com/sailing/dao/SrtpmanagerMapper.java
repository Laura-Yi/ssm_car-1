package com.sailing.dao;

import com.sailing.entity.Srtpmanager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SrtpmanagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Srtpmanager record);

    int insertSelective(Srtpmanager record);

    Srtpmanager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Srtpmanager record);

    int updateByPrimaryKey(Srtpmanager record);

    List<Srtpmanager> selectSrtpByTeacher(@Param("teacherId")Integer teacherId);

    Srtpmanager selectSrtpmanagerByStudent(@Param("studentId")String studentId);

    List<Srtpmanager> selecSrtpmanagerUnselected();

    List<Srtpmanager> selectALLSrtp();
}