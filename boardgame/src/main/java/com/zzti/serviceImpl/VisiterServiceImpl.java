package com.zzti.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzti.pojo.Visiter;
import com.zzti.service.VisiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class VisiterServiceImpl implements VisiterService {

    @Autowired
    private com.zzti.mapper.VisiterMapper visiterMapper;
    @Override
    public Visiter findOne(Integer id) {
        return visiterMapper.selectById(id);
    }
    @Override
    public List<Visiter> findAll(Map map){
        return visiterMapper.selectList(map);
    }
    @Override
    public Integer deleteByIds(Integer[] ids){
        List<Integer> ls = Arrays.asList(ids);
        return visiterMapper.deleteBatchIds(ls);
    }
    @Override
    public Integer add(Visiter vs){
        return visiterMapper.insert(vs);
    }
    @Override
    public Integer update(Visiter vs){
        return visiterMapper.updateById(vs);
    }
}
