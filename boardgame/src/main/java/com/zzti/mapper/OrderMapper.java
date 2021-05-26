package com.zzti.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderMapper {
    Map<String, Integer> selectEquCost();
    Map<String, Integer> selectVisiterCost();
    Map<String, Integer> selectGoodsCost();
    Map<String, Integer> selectAllIncome();
    List<Map<String, Integer>> selectThisYear();
    List<Map<String, Integer>> selectLastYear();

}
