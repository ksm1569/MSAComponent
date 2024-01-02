package com.smsoft.springtour.controller.exception;

public class FileDownLoadException extends RuntimeException{
    public FileDownLoadException() {
        super();
    }

    public FileDownLoadException(String message) {
        super(message);
    }

    public FileDownLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileDownLoadException(Throwable cause) {
        super(cause);
    }

    protected FileDownLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
