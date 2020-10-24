package com.yh.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yh
 * @date 2020-10-24-13:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;
    private String message;
    private T      data;

    public CommonResult(Integer code, String message){
        this.code = code;
        this.message = message;

    }

}
