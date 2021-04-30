package com.zzti.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzti.mapper.WaiterMapper;
import com.zzti.pojo.Waiter;
import com.zzti.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WaiterServiceImpl implements WaiterService {

    @Autowired
    private WaiterMapper waiterMapper;

    @Override
    public Waiter findOneWaiter(Integer id) {
        return waiterMapper.selectById(id);
    }

    @Override
    public Waiter queryByAcc(String loginUsername, String loginPassword) {
        return waiterMapper.queryByAcc(loginUsername,loginPassword);
    }


    @Override
    public List<Waiter> findAll() {
        return waiterMapper.selectList(new QueryWrapper<>(null));
    }

    @Override
    public Integer deleteByIds(Integer[] ids) {
        List<Integer> lids = Arrays.asList(ids);
        return waiterMapper.deleteBatchIds(lids);
    }

    @Override
    public Integer add(Waiter waiter) {
        return waiterMapper.insert(waiter);
    }

    @Override
    public Integer update(Waiter waiter) {
        return waiterMapper.updateById(waiter);
    }
}
