package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeeListController {
@RequestMapping("/jiaofei")
    public String jiaofei(){
    return "tourFee";
}

}
