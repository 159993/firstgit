package com.zzti.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

import java.util.Date;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderGoods {

    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer visiterId;
    @TableField(value="visiter_name")
    private String visiterName;
    private Integer goodsId;
    private String goodsName;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer number;
    private double price;
    private double total;
}
