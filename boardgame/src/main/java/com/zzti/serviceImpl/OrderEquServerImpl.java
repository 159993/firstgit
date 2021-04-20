package com.zzti.serviceImpl;


import com.sun.istack.internal.logging.Logger;
import com.zzti.mapper.OrderEquMapper;
import com.zzti.service.OrderEquServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



@Service
public class OrderEquServerImpl implements OrderEquServer {

    private static Logger log = Logger.getLogger(OrderEquServerImpl.class);

    @Autowired
    private OrderEquMapper orderEquMapper;
    @Override
    public Map selectByTime() {
        Date date = new Date();
        int timeh = date.getHours();
//        System.out.println(hours);
//
//        List<Object> timeh = new ArrayList<>();
//
//        for (int i = 0; i < hours; i+=2) {
//
//            timeh.add(i);
//        }

        System.out.println(timeh);
        Map map = orderEquMapper.selectByTime(timeh);
        System.out.println(map);

        return null;
    }
}
