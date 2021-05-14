package com.zzti.serviceImpl;

import com.zzti.mapper.OrderWaiterMapper;
import com.zzti.pojo.OrderWaiter;
import com.zzti.service.OrderWaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderWaiterServiceImpl implements OrderWaiterService {


    @Autowired
private OrderWaiterMapper orderWaiterMapper;
    @Override
    public List<OrderWaiter> selectList(Map map) {
        return orderWaiterMapper.selectList(map);
    }
}
