package com.example.springboot.controller;

import com.example.springboot.mapper.UserMapper;
import com.example.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class RegisterController {
    private  static  Integer initId=0;
    private  static  Integer sss=0;
    @Autowired
    private UserMapper userMapper;
    private  User user=new User();
    @RequestMapping("/user/register")
    public String register(@RequestParam("regname") String regname,
                      @RequestParam("regpass") String regpass,
                      @RequestParam("reregpass") String reregpass,
                      @RequestParam("email")String email,
                      Model model) {
      List<User> userList=  userMapper.queryUserList();
        for(User user:userList){
          if(user.getId()>=initId) {
              initId = user.getId();
          }
        }
        for(User user:userList){
            if(user.getUsername().equals(regname)) {
               sss++;
            }
        }
        if(regpass.equals(reregpass)&&sss==0) {
            user.setId(++initId);
            user.setUsername(regname);
            user.setPassword(regpass);
            user.setEmail(email);
            userMapper.addUser(user);
            model.addAttribute("msg1","注册成功，请登录！");
        }
        else if(sss!=0){
            model.addAttribute("sss","用户名重复，请更改！");
        }
    else{
        model.addAttribute("msg2","密码和确认密码不符合");
        }
        return "login";

    }
}
