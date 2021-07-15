package com.example.springboot.pojo;
import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourFee {
    @Excel(name = "团队编号", width = 25,orderNum = "0")
    private  String groupID;
    @Excel(name = "总消费", width = 25,orderNum = "0")
    private String consumption;
    @Excel(name = "尾款", width = 25,orderNum = "0")
    private String balance;
    @Excel(name = "已缴纳", width = 25,orderNum = "0")
    private String paid;
    @Excel(name = "活动名称", width = 25,orderNum = "0")
    private  String actName;
    @Excel(name = "用户", width = 25,orderNum = "0")
    private String actor;
}
