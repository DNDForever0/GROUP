//package com.example.springboot.controller;
//
//import com.example.springboot.mapper.MemberMapper;
//import com.example.springboot.pojo.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//public class DeleMember {
//    @Autowired
//    private MemberMapper memberMapper;
//    private Member member=new Member();
//    @RequestMapping("/dele/{id}")
//    public  String dele(@PathVariable("id") String id,
//                        Model model){
//
//        String x="x";
//        List<Member> memberList=memberMapper.queryMemberList();
//        for(Member member1:memberList){
//            if((member1.getName()+member1.getId()).equals(id)){
//                memberMapper.deleteMember(member1);
//                x=member1.getId();
//            }
//        }
//        return "redirect:/eee/x";
//
//    }
//
//}
