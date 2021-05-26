package com.zzti.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class Equipment {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private Double price;
    private Integer damage;
    private String comment;
    private Integer deleted;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    private Integer type;
    private Integer used;
}
