package com.example.springboot.mapper;


import com.example.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();
    User queryUserById();
    void addUser(User user);
    int updateUser(User user);
    int deleteUser(User user);
    String  selectEmail(String username);

}
