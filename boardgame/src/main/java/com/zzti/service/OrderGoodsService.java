package com.zzti.service;

import com.zzti.pojo.OrderGoods;

import java.util.List;
import java.util.Map;

public interface OrderGoodsService {
    List<OrderGoods> selectList(Map map);
    Integer deleteByIds(Integer[] ids);
}
