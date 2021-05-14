package com.zzti.service;

import com.zzti.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    Goods findOneGoods(Integer id);
    List<Goods> findAll(Map map);
    Integer deleteByIds(Integer[] ids);
    Integer add(Goods goods);
    Integer update(Goods goods);
}
