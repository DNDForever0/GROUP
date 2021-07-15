package com.example.springboot.mapper;

import com.example.springboot.pojo.TourFee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ExcelMapper {
    List<TourFee> list();

}
