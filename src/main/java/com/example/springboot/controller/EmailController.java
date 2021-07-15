package com.example.springboot.controller;

import com.example.springboot.mapper.MemberMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.pojo.Member;
import com.example.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmailController {
    String x="x";
    @Autowired
    JavaMailSenderImpl mailSender;
    @Autowired
    private MemberMapper memberMapper;
    private Member member=new Member();
    @Autowired
    private UserMapper userMapper;
    private User user=new User();
    @RequestMapping("/email/{id}")
    public String email(@PathVariable("id") String id,
                         Model model){
        SimpleMailMessage mailMessage=new SimpleMailMessage();

        List<Member> memberList=memberMapper.queryMemberByIdList(id);
        for(Member member:memberList){
            x=   userMapper.selectEmail(member.getName());
            mailMessage.setSubject("团员您好！");
            mailMessage.setText("团已开，请及时参加");
            mailMessage.setTo(x);
            mailMessage.setFrom("1377682584@qq.com");
            mailSender.send(mailMessage);
        }

return "index";

    }

}
