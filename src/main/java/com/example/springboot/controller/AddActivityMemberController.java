package com.example.springboot.controller;

import com.example.springboot.mapper.ActivityMapper;
import com.example.springboot.mapper.ActivityMemberMapper;
import com.example.springboot.mapper.TuanerMapper;
import com.example.springboot.pojo.Activity;
import com.example.springboot.pojo.ActivityMember;
import com.example.springboot.pojo.Tuaner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class AddActivityMemberController {
    @Autowired
    private ActivityMemberMapper activityMemberMapper;
    private ActivityMember activityMember=new ActivityMember();
    @Autowired
    private TuanerMapper tuanerMapper;
    private Tuaner tuaner;
    @Autowired
    private ActivityMapper activityMapper;
    private Activity activity=new Activity();
    @GetMapping("/addActivityMember/{activityID}")
    public void addactivitymember(@PathVariable("activityID") String activityID,
                                  HttpServletResponse response,
                                  Model model) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        PrintWriter out1=response.getWriter();
           activity=activityMapper.selectActivity(activityID);
        String x="x";
        List<Tuaner>tuanerList=tuanerMapper.queryTuanerList();
        for(Tuaner tuaner:tuanerList){
            x=tuaner.getBuilderName();
        }
        activityMember.setActor(x);
        activityMember.setGroupID( activity.getGroupID());
        activityMember.setFee( activity.getFee());
        activityMember.setActName(activity.getActName());


        List<ActivityMember>activityMemberList=activityMemberMapper.queryActivityMember();
        for(ActivityMember activityMember1:activityMemberList){
            if(activityMember1.getActName().equals(activityMember.getActName())&&activityMember1.getActor().equals(activityMember.getActor())&&activityMember1.getFee().equals(activityMember.getFee())&&activityMember1.getGroupID().equals(activityMember.getGroupID())){
                activityMemberMapper.deleteACTMember(activityMember);
                out1.print("<Script>alert('每位团员不可重复加入同一个团的同一个活动');window.location.href='/gps';</Script>");
                out1.close();
                out1.flush();
            }


        }

        activityMemberMapper.addACTMember(activityMember);
        out.print("<Script>alert('加入活动成功');window.location.href='/gps';</Script>");
        out.close();
        out.flush();

    }
}
