package com.zzti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzti.pojo.OrderEqu;
import com.zzti.pojo.OrderGoods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

public interface   OrderEquMapper extends BaseMapper<OrderEqu> {

//     Map selectByTime(@Param("timeh") Integer timeh);
     List selectByTime();
     List<OrderEqu> selectAll();
     List<OrderEqu> selectList(Map map);
     Integer updateState(String id);
     List<Map<String, Integer>> contOneMonthEqu();
}
