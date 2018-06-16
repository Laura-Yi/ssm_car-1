package com.sailing.dao;

import com.sailing.entity.Projectcost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectcostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Projectcost record);

    int insertSelective(Projectcost record);

    Projectcost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Projectcost record);

    int updateByPrimaryKey(Projectcost record);

    List<Projectcost> selectprojectCostByProject(@Param("projectId") Integer projectId);

    void deleteProjectCostByProjectId(@Param("projectId")Integer projectId);
}