package com.southwing.controller;

import com.southwing.entity.User;
import com.southwing.entity.UserList;
import com.southwing.entity.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/data")
public class DataBindHandler {
    @RequestMapping("/baseType")
    public String baseType(int id ){
        return id+"";
    }

    @RequestMapping("/packageType")
    public String packageType(Integer id){
        return id+"";
    }

    @RequestMapping("list")
    public String list(UserList userList){
        String str = "";
        for (User users: userList.getUsers()) {
            str += users.toString();
        }
        return str;
    }

    @RequestMapping("/map")
    public String map(UserMap userMap){
        StringBuffer str = new StringBuffer();
        for (String key:userMap.getUsers().keySet()) {
            User user = userMap.getUsers().get(key);
            str.append(user);
        }
        return str.toString();
    }

    @RequestMapping("json")
    public User json (@RequestBody User user){
        System.out.println(user);
        user.setName("小明");
        return user;
    }

}
