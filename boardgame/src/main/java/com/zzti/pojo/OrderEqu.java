package com.zzti.pojo;



import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderEqu {



    private Integer Id;
    private Integer visiterId;
    private String visiterName;
    private Integer equId;
    private String equName;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private Integer damage;
    private Integer state;

}