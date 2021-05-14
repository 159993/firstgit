package com.zzti.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

public class Waiter {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String account;
    private String name;
    private Integer age;
    private Integer sex;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date delTime;
    private Integer del;
    private String address;
    private String phone;
    private Double salary;
    private Integer ismanager;
    private String password;
}
