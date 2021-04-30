package com.zzti.pojo;

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
    private Date createTime;
    private Date delTime;
    private Integer del;
    private String address;
    private String phone;
    private Double salary;
    private Integer ismanager;
    private String password;
}
