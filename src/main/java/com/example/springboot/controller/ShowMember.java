package com.example.springboot.controller;

import com.example.springboot.mapper.GroupMapper;
import com.example.springboot.mapper.MemberMapper;
import com.example.springboot.pojo.GroupExample;
import com.example.springboot.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShowMember {
    @Autowired
    private MemberMapper memberMapper;
    private Member member=new Member();
    @RequestMapping("/gpsmember")
    public String showmember(Model model){

        List<Member> memberList=memberMapper.queryMemberList();

        model.addAttribute("show",memberList);
        return "MemberList1";
    }
}
