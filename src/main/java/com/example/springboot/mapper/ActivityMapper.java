package com.example.springboot.mapper;

import com.example.springboot.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ActivityMapper {

    List<Activity> queryActivityList();
    List<Activity> queryActivityListById(String groupID);
    Activity selectActivity(String activityID);
    void addActivity(Activity activity);
    void deleteActivity(Activity activity);
    void deleteActivityByID(String activityID);

}
