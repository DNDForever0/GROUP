package com.example.springboot.mapper;



import com.example.springboot.pojo.GroupExample;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository

public interface GroupMapper {

    List<GroupExample> queryGroupList();
    List<GroupExample> selectGroupList(String builderName);
    List<GroupExample> selectGroupList2(String builderName);
    GroupExample queryGroupByUnid(String builderName);
    void addGroup(GroupExample groupExample);
    void  deleteGroup(Integer groupId);
    int updateGroup(GroupExample groupExample);
    int count();



}
