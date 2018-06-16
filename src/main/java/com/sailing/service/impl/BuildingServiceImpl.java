package com.sailing.service.impl;

import com.sailing.dao.BuildingMapper;
import com.sailing.entity.Building;
import com.sailing.service.BuildingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*@description:BuildingServiceImpl
*@date: 17:10 2018/6/16
*@author: yichaoqun
*/
@Service
public class BuildingServiceImpl implements BuildingService{

    @Resource
    BuildingMapper buildingMapper;

    @Override
    public List<Building> selectAllBuilding() {
        return buildingMapper.selectAllBuilding();
    }

    @Override
    public void insert(Building building) {
        buildingMapper.insertSelective(building);
    }
}
