package com.example.springboot.controller;

import com.example.springboot.mapper.GroupMapper;
import com.example.springboot.mapper.TuanerMapper;
import com.example.springboot.pojo.GroupExample;
import com.example.springboot.pojo.Tuaner;
import com.example.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class CreateGroupController {

    @Autowired
    private GroupMapper groupMapper;
    private GroupExample groupExample=new GroupExample();
    @Autowired
    private TuanerMapper tuanerMapper;

    @RequestMapping("/tochange")
    public String toChange(){
        return "createGroup";
    }
    @RequestMapping("/change")

    public String create(GroupExample groupExample,Model model){
        String ssss="ssss";
        List<Tuaner>tuanerList=tuanerMapper.queryTuanerList();
        for(Tuaner tuaner:tuanerList){
            ssss=tuaner.getBuilderName();
        }
        groupExample.setBuilderName(ssss);
        groupExample.setGroupId(groupMapper.count()+1);
        System.out.println(groupExample);
        groupMapper.addGroup(groupExample);
        int x = groupExample.getGroupId();
        model.addAttribute("msg3", "团队的唯一编号为：" + x);
        return "redirect:/ture";
    }
}
