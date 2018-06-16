package com.sailing.service.impl;

import com.sailing.dao.ProjectcostMapper;
import com.sailing.entity.Projectcost;
import com.sailing.service.ProjectcostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*@description: ProjectcostServiceImpl
*@date: 10:11 2018/6/15
*@author: yichaoqun
*/
@Service
public class ProjectcostServiceImpl implements ProjectcostService{

    @Resource
    ProjectcostMapper projectcostMapper;

    @Override
    public List<Projectcost> selectprojectCostByProject(Integer projectId) {
        return projectcostMapper.selectprojectCostByProject(projectId);
    }

    @Override
    public void insert(Projectcost projectcost) {
        projectcostMapper.insertSelective(projectcost);
    }

    @Override
    public void deleteProjectCost(Integer projectCostId) {
        projectcostMapper.deleteByPrimaryKey(projectCostId);
    }

    @Override
    public void deleteProjectCostByProjectId(Integer projectId) {
        projectcostMapper.deleteProjectCostByProjectId(projectId);
    }


}
