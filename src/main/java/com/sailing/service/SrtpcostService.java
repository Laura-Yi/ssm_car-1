package com.sailing.service;

import com.sailing.entity.Srtpcost;

import java.util.List;

/**
*@description: Service for Srtp
*@date: 14:40 2018/6/14
*@author: yichaoqun
*/
public interface SrtpcostService {

    /**
     * 通过srtpid查询实际花费列表
     * @param srtpId
     * @return
     */
    public List<Srtpcost> selectSrtpCostBySrtpId(Integer srtpId);

    /**
     * 添加srtp花销
     * @param srtpcost
     */
    void insert(Srtpcost srtpcost);

    /**
     * 根据id删除srtp花费
     * @param srtpCostId
     */
    void delSrtpCostById(Integer srtpCostId);

    void delSrtpCostBySrtpId(Integer srtpId);
}
