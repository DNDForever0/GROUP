package com.example.springboot.mapper;

import com.example.springboot.pojo.TourFee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TourFeeMapper {
    List<TourFee> queryTourFeeList();
    void addTourFee(TourFee tourFee);
    void updateTourFee(TourFee tourFee);
    void deleteTourFee(TourFee tourFee);
}
