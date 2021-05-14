package com.zzti.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderWaiter {


    private Integer id;
    private Integer visiterId;
    private String visiterName;
    private Integer waiterId;
    private String waiterName;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer number;
    private Double price;
    private Double total;
}
