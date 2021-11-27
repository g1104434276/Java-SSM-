package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//MyBaits自带的二级缓存实体类继承Serializable实现序列化接口
//第三方ehcache则不需要实现序列化接口所以去掉implements Serializable
public class Account {
    private long id;
    private String username;
    private String password;
    private int age;
    private List<Long> ids;

    public Account(long id, String username, String password, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
