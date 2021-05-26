package com.zzti.serviceImpl;

import com.zzti.mapper.OrderMapper;
import com.zzti.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Map<String, Integer> selectEquCost() {
        return orderMapper.selectEquCost();
    }

    @Override
    public Map<String, Integer> selectVisiterCost() {
        return orderMapper.selectVisiterCost();
    }

    @Override
    public Map<String, Integer> selectGoodsCost() {
        return orderMapper.selectGoodsCost();
    }

    @Override
    public Map<String, Integer> selectAllIncome() {
        return orderMapper.selectAllIncome();
    }

    @Override
    public List<Map<String, Integer>> selectThisYear() {
        return orderMapper.selectThisYear();
    }

    @Override
    public List<Map<String, Integer>> selectLastYear() {
        return orderMapper.selectLastYear();
    }
}
