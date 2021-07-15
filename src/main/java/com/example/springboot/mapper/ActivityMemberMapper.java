package com.example.springboot.mapper;


import com.example.springboot.pojo.ActivityMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActivityMemberMapper {
    List<ActivityMember> queryActivityMember();
    List<ActivityMember> queryActivityMemberByActor(String actor);
    Integer count(@Param("groupID") String groupID,@Param("actName")String actName);
    void addACTMember(ActivityMember activityMember);
    void deleteACTMember(ActivityMember activityMember);
}
