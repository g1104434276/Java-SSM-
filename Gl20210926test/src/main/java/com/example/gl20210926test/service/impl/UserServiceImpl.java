package com.example.gl20210926test.service.impl;

import com.example.gl20210926test.dao.UserDao;
import com.example.gl20210926test.domain.SysUser;
import com.example.gl20210926test.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = null;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public void addUser(SysUser user) {
        userDao.inserUser(user);
    }
}
