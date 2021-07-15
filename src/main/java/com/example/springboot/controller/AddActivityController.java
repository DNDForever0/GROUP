package com.example.springboot.controller;

import com.example.springboot.mapper.ActivityMapper;
import com.example.springboot.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class AddActivityController {
    @Autowired
    private ActivityMapper activityMapper;
    private Activity activity=new Activity();
    @RequestMapping("/addActivity")
    public  void addActivity(@RequestParam("groupID") String groupID,
                               @RequestParam("actName") String actName,
                               @RequestParam("fee")String fee,
                               @RequestParam("activityID")String activityID,
                               HttpServletResponse response,
                               Model model) throws IOException {



        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        PrintWriter out1=response.getWriter();
        activity.setActName(actName);
        activity.setFee(fee);
        activity.setGroupID(groupID);
        activity.setActivityID(activityID);

        List<Activity> activityList=activityMapper.queryActivityList();
        for(Activity activity1:activityList){
            if(activity1.getActName().equals(activity.getActName())&&activity1.getGroupID().equals(activity.getGroupID())){
              activityMapper.deleteActivity(activity);
                out1.print("<Script>alert('同一种活动不可重复创建');window.location.href='/bbb';</Script>");
                out1.close();
                out1.flush();
            }
        }

        activityMapper.addActivity(activity);
        out.print("<Script>alert('创建活动成功');window.location.href='/bbb';</Script>");
        out.close();
        out.flush();
    }
}
