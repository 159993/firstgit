package com.zzti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzti.pojo.OrderGoods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderGoodsMapper extends BaseMapper<OrderGoods> {

    List<OrderGoods> selectList(Map map);

}
