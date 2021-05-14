package com.zzti.serviceImpl;


import com.sun.istack.internal.logging.Logger;
import com.zzti.mapper.OrderEquMapper;
import com.zzti.pojo.OrderEqu;
import com.zzti.pojo.SysResult;
import com.zzti.service.OrderEquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class OrderEquServiceImpl implements OrderEquService {


    @Autowired
    private OrderEquMapper orderEquMapper;
    @Override
    public int[] selectByTime() {
        int[] arr = new int[12];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=0;
        }
        List<OrderEqu> ls = orderEquMapper.selectByTime();
        System.out.println(ls);
        for (OrderEqu or:ls) {
            int hours=or.getCreateTime().getHours();
            arr[hours/2]++;
        }
        return arr;
    }

    @Override
    public List<OrderEqu> slectAll() {
        return orderEquMapper.selectAll();
    }

    @Override
    public List<OrderEqu> slectList(Map map) {
        List<OrderEqu> orderEqus = orderEquMapper.selectList(map);
//        Integer done ;
//        for (OrderEqu s:orderEqus) {
//            Date e = s.getEndTime();
//            Date c = s.getCreateTime();
//            Data cd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c);
//            String ed = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(e);
//            s.setCreateTime(cd);
//        }

        List<OrderEqu> res = orderEqus;

        return res;
    }

    @Override
    public Integer updateState(String id) {
        return orderEquMapper.updateState(id);
    }

    @Override
    public Integer deleteByIds(Integer[] ids) {
        List<Integer> lids = Arrays.asList(ids);
        return orderEquMapper.deleteBatchIds(lids);
    }

    @Override
    public List<Map<String, Integer>> contOneMonthEqu() {
        return orderEquMapper.contOneMonthEqu();
    }

}

