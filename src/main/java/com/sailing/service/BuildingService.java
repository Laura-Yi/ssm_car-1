package com.sailing.service;

import com.sailing.entity.Building;

import java.util.List;

/**
*@description: BuildingService
*@date: 17:04 2018/6/16
*@author: yichaoqun
*/
public interface BuildingService {
    public List<Building> selectAllBuilding();

    void insert(Building building);
}
