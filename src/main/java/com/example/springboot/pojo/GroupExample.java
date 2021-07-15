package com.example.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupExample {
    private  Integer groupId;
    private String groupName;
    private  String maxNumber;
    private  String startTime;
    private  String endTime;
    private String builderName;
}
