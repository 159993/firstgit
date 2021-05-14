package com.zzti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzti.pojo.OrderWaiter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderWaiterMapper extends BaseMapper<OrderWaiter> {

    List<OrderWaiter> selectList(Map map);
}
