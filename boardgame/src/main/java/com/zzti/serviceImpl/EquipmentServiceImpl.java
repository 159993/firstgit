package com.zzti.serviceImpl;

import com.zzti.mapper.EquipmentMapper;
import com.zzti.pojo.Equipment;
import com.zzti.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> selectList(Map map) {
        return equipmentMapper.selectList(map);
    }

    @Override
    public Integer update(Equipment equipment) {
        return equipmentMapper.updateById(equipment);
    }

    @Override
    public Integer add(Equipment equipment) {
        return equipmentMapper.insert(equipment);
    }
    public Integer deleteByIds(Integer[] ids) {
        List<Integer> lids = Arrays.asList(ids);
        return equipmentMapper.deleteBatchIds(lids);
    }

    @Override
    public Equipment findOneGoods(Integer id) {
        return equipmentMapper.selectById(id);
    }
}
