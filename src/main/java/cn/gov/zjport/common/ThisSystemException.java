package cn.gov.zjport.common;

public class ThisSystemException extends RuntimeException {
    public ThisSystemException(String message) {
        super(message);
    }

    public ThisSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
