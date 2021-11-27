package com.example.gl20210926test.dao.impl;

import com.example.gl20210926test.dao.UserDao;
import com.example.gl20210926test.domain.SysUser;

public class MySqlUserDaoImpl implements UserDao {
    @Override
    public void inserUser(SysUser user) {
        System.out.println("姓名:" + user.getName());
        System.out.println("年龄:" + user.getAge());
        System.out.println("执行了数据库的insert操作");
    }
}
