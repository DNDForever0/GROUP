package com.example.springboot.controller;

import com.example.springboot.dao.GroupDao;

import com.example.springboot.pojo.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class OrganizeController {
    @Autowired
    GroupDao groupDao;
    @RequestMapping(value={"/bbb","/organize"})

    public String list(Model model){

        Collection<Group> groups=groupDao.getGroups();
        model.addAttribute("gps",groups);
        return "organizeAct";
    }
}
