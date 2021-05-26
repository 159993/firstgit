package com.zzti.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Visiter {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String name;
    private String account;
    private String password;
    private String comment;
    private String photo;
    private Integer age;
    private Integer sex;
    private Integer del;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
