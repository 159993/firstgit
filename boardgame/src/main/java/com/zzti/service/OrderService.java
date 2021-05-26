package com.zzti.service;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<String, Integer> selectEquCost();
    Map<String, Integer> selectVisiterCost();
    Map<String, Integer> selectGoodsCost();
    Map<String, Integer> selectAllIncome();
    List<Map<String, Integer>> selectThisYear();
    List<Map<String, Integer>> selectLastYear();
}
