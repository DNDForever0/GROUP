package com.example.springboot.controller;


import com.example.springboot.mapper.TourFeeMapper;
import com.example.springboot.pojo.TourFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JiaoFeiController {
    @Autowired
    private TourFeeMapper tourFeeMapper;
    private TourFee tourFee=new TourFee();
    @GetMapping("/tijiao")

    public String  tijiao(@RequestParam("actor")String actor,
                          @RequestParam("actName")String actName,
                        @RequestParam("groupID")String groupID,
                        @RequestParam("money")String  money,
                        Model model){
        Integer x=Integer.parseInt(money);
        List<TourFee> tourFeeList=tourFeeMapper.queryTourFeeList();
        for(TourFee tourFee:tourFeeList){
            if(tourFee.getGroupID().equals(groupID)&&tourFee.getActName().equals(actName)&&tourFee.getActor().equals(actor)){
                Integer y=Integer.parseInt(tourFee.getPaid());
                x+=y;

            }
        }
        String m=String.valueOf(x);
tourFee.setPaid(m);
tourFee.setActor(actor);
tourFee.setActName(actName);
tourFee.setGroupID(groupID);
tourFeeMapper.updateTourFee(tourFee);

        return "redirect:/fee";


    }
}
