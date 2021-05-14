package com.zzti.service;

import com.zzti.pojo.OrderEqu;

import java.util.List;
import java.util.Map;

public interface OrderEquService {
//   Map selectByTime();
   int[] selectByTime();
   List<OrderEqu> slectAll();
   List<OrderEqu> slectList(Map map);
   Integer updateState(String id);
   Integer deleteByIds(Integer[] ids);
   List<Map<String, Integer>> contOneMonthEqu();
}
