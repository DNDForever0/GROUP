package com.example.springboot.controller;

import com.example.springboot.Util.WebExcelUtil;
import com.example.springboot.mapper.ExcelMapper;
import com.example.springboot.pojo.TourFee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
public class ExcelController {
    @Autowired
    ExcelMapper excelMapper;
    @RequestMapping("/pay/export")
    public void export(HttpServletResponse response) {
        List<TourFee> list = excelMapper.list();
        WebExcelUtil.exportExcel(list, "缴费表", "sheet1", TourFee.class, "活动账单.xls", response);
    }

}
