package com.zzti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzti.pojo.Waiter;
import org.springframework.stereotype.Repository;

@Repository
public interface WaiterMapper extends BaseMapper<Waiter> {

    Waiter queryByAcc(String loginUsername,String loginPassword);
}
