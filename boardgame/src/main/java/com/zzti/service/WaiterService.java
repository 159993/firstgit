package com.zzti.service;

import com.zzti.pojo.Waiter;

import java.util.List;
import java.util.Map;

public interface WaiterService {
    Waiter findOneWaiter(Integer id);
    Waiter queryByAcc(String loginUsername,String loginPassword);
    Waiter queryManager(String loginUsername,String loginPassword);
    List<Waiter> findAll(Map map);
    Integer deleteByIds(Integer[] ids);
    Integer add(Waiter waiter);
    Integer update(Waiter waiter);
}
