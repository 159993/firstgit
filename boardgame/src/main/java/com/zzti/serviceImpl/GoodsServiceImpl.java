package com.zzti.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzti.mapper.GoodsMapper;
import com.zzti.pojo.Goods;
import com.zzti.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods findOneGoods(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public List<Goods> findAll(Map map) {
        return goodsMapper.selectList(map);
    }

    @Override
    public Integer deleteByIds(Integer[] ids) {
        List<Integer> ls = Arrays.asList(ids);
        return goodsMapper.deleteBatchIds(ls);
    }

    @Override
    public Integer add(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public Integer update(Goods goods) {
        return goodsMapper.update(goods);
    }
}
