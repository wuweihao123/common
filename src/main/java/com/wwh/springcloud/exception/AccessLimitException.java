package com.wwh.springcloud.exception;

public class AccessLimitException extends Exception {
    public AccessLimitException(String message) {
        super(message);
    }
}
