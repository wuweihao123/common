package com.wwh.springcloud.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SystemRuntimeException extends RuntimeException {
    protected String errorCode = "404";

    protected Object data;

    public SystemRuntimeException(String message, Throwable cause, String errorCode) {
        super(message == null ? errorCode : message + "{" + errorCode + "}", cause);
        this.errorCode = errorCode;
    }

    public SystemRuntimeException(String message, String errorCode) {
        super(message == null ? errorCode : message + "{" + errorCode + "}");
        this.errorCode = errorCode;
    }

    public SystemRuntimeException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    /**
     * noParentheses为true时，返回的时候message不加{errorCode}
     *
     * @param message
     * @param errorCode
     * @param noParentheses
     */
    public SystemRuntimeException(String message, String errorCode, boolean noParentheses) {
        super(message == null ? errorCode : noParentheses ? message : message + "{" + errorCode + "}");
        this.errorCode = errorCode;
    }
}
