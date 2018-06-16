package com.sailing.dao;

import com.sailing.entity.Schedulecourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulecourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Schedulecourse record);

    int insertSelective(Schedulecourse record);

    Schedulecourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Schedulecourse record);

    int updateByPrimaryKey(Schedulecourse record);

    void updateScheduleByClassAndTime(@Param("educationplan")Integer educationplan,@Param("classroom")Integer classroom, @Param("time")Integer time);

    List<Integer> selectUnScheduleIds();

    List<Schedulecourse> selectScheduleByClassId(@Param("classroom")Integer classroom);

    Schedulecourse selectScheduleByClassAndTime(@Param("classroom")Integer classroom, @Param("time")Integer time);
}