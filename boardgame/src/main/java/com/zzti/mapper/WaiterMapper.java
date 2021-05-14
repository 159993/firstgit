package com.zzti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzti.pojo.Waiter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WaiterMapper extends BaseMapper<Waiter> {

    Waiter queryByAcc(String loginUsername,String loginPassword);
    Waiter queryManager(String loginUsername,String loginPassword);
    List<Waiter> selectList(Map map);
}
