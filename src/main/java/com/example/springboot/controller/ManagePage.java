package com.example.springboot.controller;


import com.example.springboot.mapper.MemberMapper;
import com.example.springboot.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManagePage {
    @Autowired
    private MemberMapper memberMapper;
    private Member member=new Member();
    @RequestMapping("/managegps/{id}")
    public String manage(@PathVariable("id") String id,
            Model model){
        List<Member> memberList=memberMapper.queryMemberByIdList(id);
        model.addAttribute("manage",memberList);
        return "MemberList2";
    }

}
