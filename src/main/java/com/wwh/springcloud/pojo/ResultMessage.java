package com.wwh.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一结果返回处理类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultMessage implements Serializable {
    private Integer code = 500;

    private String msg = "";

    private Boolean success = true;

    private Object data = null;
}
