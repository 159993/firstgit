package com.zzti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzti.pojo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    List<Goods> selectList(Map map);
    Integer update(Goods goods);
}
