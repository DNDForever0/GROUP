package com.example.springboot.controller;

import com.example.springboot.mapper.GroupMapper;

import com.example.springboot.pojo.GroupExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupMapper groupMapper;
    @GetMapping("/queryGroupList")
    public List<GroupExample> queryGroupList(){
        List<GroupExample> groupList=groupMapper.queryGroupList();
        for(GroupExample groupExample:groupList){
            System.out.println(groupExample);
        }
        return groupList;
    }

}
