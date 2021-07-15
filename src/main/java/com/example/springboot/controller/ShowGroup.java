package com.example.springboot.controller;
import com.example.springboot.mapper.GroupMapper;
import com.example.springboot.mapper.TuanerMapper;
import com.example.springboot.pojo.GroupExample;
import com.example.springboot.pojo.Tuaner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.List;

@Controller
public class ShowGroup {

@Autowired
private TuanerMapper tuanerMapper;
@Autowired
private GroupMapper groupMapper;
    @RequestMapping("/gps")
    public String list(Model model){
        String sss="sss";
         List<Tuaner> tuanerList=tuanerMapper.queryTuanerList();
         for(Tuaner tuaner:tuanerList){
            sss=tuaner.getBuilderName();
              }
        List<GroupExample> groupList=groupMapper.queryGroupList();
        for(GroupExample groupExample:groupList) {
            if (groupExample.getGroupName()==null) {
                groupMapper.deleteGroup(groupExample.getGroupId());
            }
        }
        List<GroupExample> groupExampleList=groupMapper.selectGroupList(sss);

        model.addAttribute("gps",groupExampleList);

        return "joinGroup";

    }



}
