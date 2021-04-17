package com.zzti.service;

import com.zzti.pojo.Goods;

import java.util.List;

public interface GoodsService {
    Goods findOneGoods(Integer id);
    List<Goods> findAll();
    Integer deleteByIds(Integer[] ids);
    Integer add(Goods goods);
    Integer update(Goods goods);
}
