package com.wwh.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultMessage {
    private Integer code;

    private String msg;

    private Boolean success;

    private Object data;
}
