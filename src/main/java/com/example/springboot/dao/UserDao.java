package com.example.springboot.dao;
import com.example.springboot.pojo.User;

import java.util.HashMap;
import java.util.Map;


public class UserDao {
    public static Map<Integer, User> users=null;
    static {
        users = new HashMap<Integer, User>();
        users.put(1,new User(1,"lzp","418618","1377682584@qq.com"));

    }
}
