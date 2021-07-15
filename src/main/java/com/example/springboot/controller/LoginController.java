package com.example.springboot.controller;
import com.example.springboot.mapper.MemberMapper;
import com.example.springboot.mapper.TuanerMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.pojo.Member;
import com.example.springboot.pojo.Tuaner;
import com.example.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@Controller
public class LoginController {
    @Autowired
    private MemberMapper memberMapper;
    private Member member=new Member();
    @Autowired
private UserMapper userMapper;
@Autowired
private TuanerMapper tuanerMapper;
private  Tuaner tuaner=new Tuaner();
    public LoginController() {
    }

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
//用来判别登陆者的身份，方便区分自己创建团队和加入他人团队
tuanerMapper.deleteTuaner();
tuaner.setBuilderName(username);
tuanerMapper.addTuaner(tuaner);
//遍历底层数据库，判断登陆用户用户名和密码和数据库中是否相同
  String x="false";
    List<User> userList=userMapper.queryUserList();
    for(User user:userList){
        if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
            x="success";
        }
    }
    if(x.equals("success")){
        return "index";
    }
    else {
        model.addAttribute("msg","用户名或者密码错误！");
        return "login";
    }
} }
