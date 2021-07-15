package com.example.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
//团员
public class GroupMember {
    private Integer id;
    private String name;
    private  Integer gender;//0:男   1：女
    private Group group;//所属团





}
