package com.zzti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.xml.crypto.Data;
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
    private Data createTime;
    private Data updateTime;
}
