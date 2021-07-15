package com.example.springboot.mapper;

import com.example.springboot.pojo.Member;
import com.example.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {

    List<Member> queryMemberList();
    List<Member> queryMemberByIdList(String id);
    void addMember(Member member);
    int updateMember(Member member);
    int deleteMember(Member member);
}
