package com.zzti.service;

import com.zzti.pojo.Waiter;

import java.util.List;

public interface WaiterService {
    Waiter findOneWaiter(Integer id);
    Waiter queryByAcc(String loginUsername,String loginPassword);
    List<Waiter> findAll();
    Integer deleteByIds(Integer[] ids);
    Integer add(Waiter waiter);
    Integer update(Waiter waiter);
}
