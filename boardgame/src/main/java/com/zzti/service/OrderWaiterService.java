package com.zzti.service;

import com.zzti.pojo.OrderWaiter;

import java.util.List;
import java.util.Map;

public interface OrderWaiterService {
    List<OrderWaiter> selectList(Map map);
}
