package com.zzti.service;

import com.zzti.pojo.Visiter;

import java.util.List;
import java.util.Map;

public interface VisiterService {
    Visiter findOne(Integer id);
    List<Visiter> findAll(Map map);
    Integer deleteByIds(Integer[] ids);
    Integer add(Visiter vs);
    Integer update(Visiter vs);
}
