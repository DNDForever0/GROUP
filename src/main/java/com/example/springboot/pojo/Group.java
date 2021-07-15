package com.example.springboot.pojo;
//组团
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private Integer id;//团序号
    private String name;//团名
    private Integer number;//所需要人数
    private String time;
    private String end;
    private String work;
}
