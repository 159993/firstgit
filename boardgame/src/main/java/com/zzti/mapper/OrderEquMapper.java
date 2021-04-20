package com.zzti.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzti.pojo.OrderEqu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

public interface   OrderEquMapper extends BaseMapper<OrderEqu> {

     Map selectByTime(@Param("timeh") Integer timeh);
}
