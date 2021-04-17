package com.zzti.serviceImpl;

import com.zzti.mapper.EquipmentMapper;
import com.zzti.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

}
