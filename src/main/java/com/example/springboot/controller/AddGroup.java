package com.example.springboot.controller;


import com.example.springboot.mapper.GroupMapper;
import com.example.springboot.mapper.MemberMapper;
import com.example.springboot.mapper.TuanerMapper;
import com.example.springboot.pojo.GroupExample;
import com.example.springboot.pojo.Member;
import com.example.springboot.pojo.Tuaner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class AddGroup {
@Autowired
private MemberMapper memberMapper;
private Member member=new Member();
@Autowired
    private TuanerMapper tuanerMapper;
    private  Tuaner tuaner;
@Autowired
private GroupMapper groupMapper;
private GroupExample groupExample=new GroupExample();

    @GetMapping("/addgps/{groupID}")
    public void add(@PathVariable("groupID") String groupID,
            HttpServletResponse response) throws IOException {


         String x="x";
        List<Tuaner>tuanerList=tuanerMapper.queryTuanerList();
        for(Tuaner tuaner:tuanerList){
            x=tuaner.getBuilderName();
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        PrintWriter out1=response.getWriter();



        member.setId(groupID);
        member.setName(x);

        List<Member>memberList=memberMapper.queryMemberList();
        for(Member member1:memberList){
            if(member1.getId().equals(member.getId())&&member1.getName().equals(member.getName())){
                memberMapper.deleteMember(member);
                out1.print("<Script>alert('不可重复加入');window.location.href='/gps';</Script>");
                out1.close();
                out1.flush();
            }
        }
        memberMapper.addMember(member);
        out.print("<Script>alert('加入成功');window.location.href='/gps';</Script>");
        out.close();
        out.flush();

    }

}
