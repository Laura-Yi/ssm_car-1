package com.sailing.service;

import com.sailing.entity.Admin;

/**
*@description: Service For Admin
*@date: 18:17 2018/6/5
*@author: yichaoqun
*/
public interface AdminService {
    /**
     * 验证管理员的登陆
     * @param username
     * @param password
     * @return
     */
    public Admin checkLogin(String username, String password);

    Admin selectAdminByUsername(String username);

    void insert(String username, String s);
}
