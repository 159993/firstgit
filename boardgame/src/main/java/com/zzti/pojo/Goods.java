package com.zzti.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Goods {
    private Integer id;
    private String name;
    private double sellPrice;
    private double purPrice;
    private Integer number;
    private String type;
}
