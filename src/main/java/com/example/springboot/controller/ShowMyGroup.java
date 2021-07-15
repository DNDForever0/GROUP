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
public class ShowMyGroup {
    @Autowired
    private TuanerMapper tuanerMapper;
    @Autowired
    private GroupMapper groupMapper;
    @RequestMapping("/ture")
    public String list1(Model model){
        String ssss="ssss";
        List<Tuaner> tuanerList1=tuanerMapper.queryTuanerList();
        for(Tuaner tuaner:tuanerList1){
            ssss=tuaner.getBuilderName();
        }
        List<GroupExample> groupList=groupMapper.queryGroupList();
        for(GroupExample groupExample:groupList) {
            if (groupExample.getGroupName()==null) {
                groupMapper.deleteGroup(groupExample.getGroupId());
            }
        }
        List<GroupExample> groupExampleList=groupMapper.selectGroupList2(ssss);

     model.addAttribute("showMyGroup",groupExampleList);

        return "Confirm";
    }



}
