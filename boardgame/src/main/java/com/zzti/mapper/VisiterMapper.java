package com.zzti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzti.pojo.Visiter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VisiterMapper extends BaseMapper<Visiter> {
    List<Visiter> selectList(Map map);
    @Override
    int updateById(Visiter entity);
}
