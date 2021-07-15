package com.example.springboot.dao;

import com.example.springboot.pojo.Group;
import com.example.springboot.pojo.GroupMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class GroupMemberDao {
    private static Map<Integer, GroupMember> groupMembers=null;
@Autowired
private GroupDao groupDao;
    static {
        groupMembers = new HashMap<Integer, GroupMember>();
        groupMembers.put(1,new GroupMember(1,"lzp",0,new Group(1,"jsj",18,"2019-9","2019-10","上方山")));
        groupMembers.put(2,new GroupMember(2,"LZP",0,new Group(1,"jsj",18,"2019-9","2019-10","上方山")));
    }

    //全输出展示
    public Collection<GroupMember> getGroups(){
        return  groupMembers.values();
    }
    //通过id查找组团
    public  GroupMember getGroupMember(Integer id){
        return  groupMembers.get(id);
    }
    //增加团员
    private  static  Integer initId=3;
    public void add(GroupMember groupMember){
        if(groupMember.getId()==null){
            groupMember.setId(initId++);
        }
        groupMember.setGroup(groupDao.getGroupById(groupMember.getGroup().getId()));
        groupMembers.put(groupMember.getId(),groupMember);
    }
    //删除团员ById
    public void delete(Integer id){
        groupMembers.remove(id);
    }

}
