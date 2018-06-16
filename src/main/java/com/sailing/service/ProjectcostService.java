package com.sailing.service;

import com.sailing.entity.Projectcost;

import java.util.List;

/**
*@description: Service For Service
*@date: 10:09 2018/6/15
*@author: yichaoqun
*/
public interface ProjectcostService {

    List<Projectcost> selectprojectCostByProject(Integer projectId);

    void insert(Projectcost projectcost);

    void deleteProjectCost(Integer projectCostId);

    void deleteProjectCostByProjectId(Integer projectId);
}
