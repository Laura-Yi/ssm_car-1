package com.sailing.service.impl;

import com.sailing.dao.AdminMapper;
import com.sailing.entity.Admin;
import com.sailing.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
*@description: ServiceImpl For Admin
*@date: 18:17 2018/6/5
*@author: yichaoqun
*/
@Service
public class AdminServiceImpl implements AdminService{

    @Resource
    AdminMapper adminMapper;

    @Override
    public Admin checkLogin(String username, String password) {
        Admin admin = adminMapper.selectByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        } else return null;
    }

    @Override
    public Admin selectAdminByUsername(String username) {
        return adminMapper.selectByUsername(username);
    }

    @Override
    public void insert(String username, String s) {
        Admin admin = new Admin();
        admin.setName(username);
        admin.setPassword(s);
        adminMapper.insertSelective(admin);
    }
}
