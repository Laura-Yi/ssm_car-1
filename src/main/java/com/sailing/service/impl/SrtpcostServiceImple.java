package com.sailing.service.impl;

import com.sailing.dao.SrtpcostMapper;
import com.sailing.entity.Srtpcost;
import com.sailing.service.SrtpcostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*@description: Service for srtp实际花费
*@date: 14:42 2018/6/14
*@author: yichaoqun
*/
@Service
public class SrtpcostServiceImple implements SrtpcostService{

    @Resource
    SrtpcostMapper srtpcostMapper;


    @Override
    public List<Srtpcost> selectSrtpCostBySrtpId(Integer srtpId) {
        return srtpcostMapper.selectSrtpCostBySrtpId(srtpId);
    }

    @Override
    public void insert(Srtpcost srtpcost) {
        srtpcostMapper.insertSelective(srtpcost);
    }

    @Override
    public void delSrtpCostById(Integer srtpCostId) {
        srtpcostMapper.deleteByPrimaryKey(srtpCostId);
    }

    @Override
    public void delSrtpCostBySrtpId(Integer srtpId) {
        srtpcostMapper.deleteSrtpCostBySrtp(srtpId);
    }
}
