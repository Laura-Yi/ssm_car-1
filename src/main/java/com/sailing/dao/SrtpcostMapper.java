package com.sailing.dao;

import com.sailing.entity.Srtpcost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SrtpcostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Srtpcost record);

    int insertSelective(Srtpcost record);

    Srtpcost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Srtpcost record);

    int updateByPrimaryKey(Srtpcost record);

    List<Srtpcost> selectSrtpCostBySrtpId(@Param("srtpId") Integer srtpId);

    void deleteSrtpCostBySrtp(@Param("srtpId")Integer srtpId);
}