package com.zzti.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
@Data
public class SysResult {
    private Integer status;
    private String message;
    private Object data;
    public static SysResult success(){
        return new SysResult(200,"业务调用成功",null);
    }
    public static SysResult success(Object data){
        return new SysResult(200,"业务调用成功",data);
    }
    public static SysResult success(String message,Object data){
        return new SysResult(200,message,data);
    }
    public static SysResult fail(){
        return new SysResult(201,"业务调用失败",null);
    }
}
