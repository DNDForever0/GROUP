package com.example.springboot.controller;


import com.example.springboot.mapper.ActivityMemberMapper;
import com.example.springboot.mapper.TourFeeMapper;
import com.example.springboot.mapper.TuanerMapper;
import com.example.springboot.pojo.ActivityMember;
import com.example.springboot.pojo.Group;
import com.example.springboot.pojo.TourFee;
import com.example.springboot.pojo.Tuaner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class FeeController {
    @Autowired
    private TourFeeMapper tourFeeMapper;
    private TourFee tourFee=new TourFee();
    @Autowired
    private ActivityMemberMapper activityMemberMapper;
    private ActivityMember activityMember=new ActivityMember();
    @Autowired
    private TuanerMapper tuanerMapper;
    @RequestMapping("/fee")
    public String  jiaofee(Model model){

        String sss="sss";
        List<Tuaner> tuanerList=tuanerMapper.queryTuanerList();
        for(Tuaner tuaner:tuanerList){
            sss=tuaner.getBuilderName();
        }
//activityMember中所有当前用户的所有信息（团id，actname，fee）
        List<ActivityMember> activityMemberList = activityMemberMapper.queryActivityMemberByActor(sss);
        List<TourFee>tourFeeList=tourFeeMapper.queryTourFeeList();
        System.out.println("1:"+activityMemberList);
        for(ActivityMember activityMember:activityMemberList){
            Integer x=activityMemberMapper.count(activityMember.getGroupID(),activityMember.getActName());
            Integer y=Integer.parseInt(activityMember.getFee())/x;//R人均费用
            tourFee.setGroupID(activityMember.getGroupID());
            tourFee.setActName(activityMember.getActName());
            tourFee.setActor(sss);
            tourFee.setConsumption(String.valueOf(y));
            tourFee.setBalance(String.valueOf(y));
            tourFee.setPaid("0");
            for(TourFee tourFee2:tourFeeList){
                if(tourFee2.getGroupID().equals(tourFee.getGroupID())&&tourFee2.getActName().equals(tourFee2.getActName())){
                    tourFee.setPaid(tourFee2.getPaid());
                    tourFeeMapper.deleteTourFee(tourFee);

                }
            }
            tourFeeMapper.addTourFee(tourFee);

        }
        model.addAttribute("tourfee",tourFeeList);
        return"feeList";
    }
}
