package com.zzti.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzti.pojo.Equipment;

import java.util.List;
import java.util.Map;

public interface EquipmentService {
    List<Equipment> selectList(Map map);
    Integer update(Equipment equipment);
    Integer add(Equipment equipment);
    Equipment findOneGoods(Integer id);
    Integer deleteByIds(Integer[] ids);
}
