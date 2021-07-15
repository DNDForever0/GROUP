package com.example.springboot.mapper;

import com.example.springboot.pojo.Tuaner;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TuanerMapper {

    List<Tuaner> queryTuanerList();
    void addTuaner(Tuaner tuaner);
    Tuaner queryTuanerByName(String builderName);
    void  deleteTuaner();
}
