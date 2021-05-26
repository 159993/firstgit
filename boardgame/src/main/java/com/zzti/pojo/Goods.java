package com.zzti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private Double sellPrice;
    private Double purPrice;
    private Integer totalPurchase;
    private Integer number;
    private String type;

}
