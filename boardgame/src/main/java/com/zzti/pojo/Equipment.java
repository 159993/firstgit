package com.zzti.pojo;


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
    private Integer id;
    private String name;
    private Double price;
    private Integer damage;
    private String comment;
    private Integer delete;
    private Date create_time;
    private Integer type;
    private Integer use;
}
