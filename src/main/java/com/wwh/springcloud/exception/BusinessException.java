package com.wwh.springcloud.exception;

/**
 * 自定义异常
 */
public class BusinessException extends Exception{

    public BusinessException(String message) {
        super(message);
    }
}
