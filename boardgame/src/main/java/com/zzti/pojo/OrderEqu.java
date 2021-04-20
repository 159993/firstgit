package com.zzti.pojo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderEqu {

    private Integer id;
    private Integer visterId;
    private Integer ruqId;
    private Date createTime;
    private Date endTime;
    private Integer damage;

}
