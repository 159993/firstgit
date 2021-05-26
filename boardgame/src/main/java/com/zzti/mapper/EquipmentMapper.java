package com.zzti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzti.pojo.Equipment;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EquipmentMapper extends BaseMapper<Equipment>{
    List<Equipment> selectList(Map map);
}
