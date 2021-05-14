package com.zzti.serviceImpl;

import com.zzti.mapper.OrderGoodsMapper;
import com.zzti.pojo.OrderGoods;
import com.zzti.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {

    @Autowired
    private com.zzti.mapper.OrderGoodsMapper orderGoodsMapper;


    @Override
    public List<OrderGoods> selectList(Map map) {
        return orderGoodsMapper.selectList(map);
    }

    @Override
    public Integer deleteByIds(Integer[] ids) {
        List<Integer> lids = Arrays.asList(ids);
        return orderGoodsMapper.deleteBatchIds(lids);

    }
}
