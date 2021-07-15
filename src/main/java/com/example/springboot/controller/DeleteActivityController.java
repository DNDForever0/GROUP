package com.example.springboot.controller;

import com.example.springboot.mapper.ActivityMapper;
import com.example.springboot.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteActivityController {
    @Autowired
    private ActivityMapper activityMapper;
    private  Activity activity;
    @GetMapping("/deleteActivity/{id}")
    public String deleteActivity(Model model, @PathVariable String id){
                  activityMapper.deleteActivityByID(id);
return "redirect:/ture";

    }
}
