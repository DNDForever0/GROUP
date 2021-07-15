package com.example.springboot.controller;

import com.example.springboot.mapper.ActivityMapper;
import com.example.springboot.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ManageActivityController {
    @Autowired
    private ActivityMapper activityMapper;
    private Activity activity;
    @GetMapping("/hhh/{id}")
    public  String MangageActivity(@PathVariable("id") String id,
                               Model model){
        List<Activity> activityList= activityMapper.queryActivityListById(id);
        model.addAttribute("showmsg2",activityList);
        return "ActivityList2";

    }
}
