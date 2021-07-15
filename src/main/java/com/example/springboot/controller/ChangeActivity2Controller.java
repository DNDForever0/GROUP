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
public class ChangeActivity2Controller {
    @Autowired
    private ActivityMapper activityMapper;
    private Activity activity = new Activity();

    @RequestMapping("/changeactivity2")
    public void ChangeActivity2(@RequestParam("groupID") String groupID,
                                @RequestParam("actName") String actName,
                                @RequestParam("fee") String fee,
                                @RequestParam("activityID") String activityID,
                                HttpServletResponse response, Model model) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out1 = response.getWriter();
        activity.setActName(actName);
        activity.setFee(fee);
        activity.setGroupID(groupID);
        activity.setActivityID(activityID);
        List<Activity> activityList = activityMapper.queryActivityList();
        for (Activity activity1 : activityList) {
            if (activity1.getActivityID().equals(activity.getActivityID())) {
                activityMapper.deleteActivity(activity1);
                activityMapper.addActivity(activity);
                out1.print("<Script>alert('x修改成功');window.location.href='/ture';</Script>");
                out1.close();
                out1.flush();
            }

        }

    }
}
