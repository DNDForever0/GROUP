package com.example.springboot.dao;


import com.example.springboot.pojo.Group;
import com.example.springboot.pojo.GroupMember;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class GroupDao {
    public static Map<Integer,Group>groups=null;
    static {
        groups = new HashMap<Integer, Group>();
        groups.put(1,new Group(1,"jsj",18,"2019-9","2019-10","上方山"));
        groups.put(2,new Group(2,"jsj",19,"2019-9","2019-10","上方山"));
        groups.put(3,new Group(3,"jsj",10,"2019-9","2019-10","上方山"));
        groups.put(4,new Group(4,"jsj",122,"2019-9","2019-10","上方山"));
        groups.put(5,new Group(5,"jsj",14,"2019-9","2019-10","上方山"));

    }
    //全输出展示
    public Collection<Group>getGroups(){
        return  groups.values();
    }
    //通过id查找组团
    public  Group getGroupById(Integer id){
        return  groups.get(id);
    }

    //增加团
    private  static  Integer initId=6;
    public void add(Group group){
        if(group.getId()==null){
            group.setId(initId++);

            groups.put(group.getId(),new Group(group.getId(),"name",20,"2019-9","2019-10","上方山"));//尚未实现将注册的团信息
        }
    }

}
