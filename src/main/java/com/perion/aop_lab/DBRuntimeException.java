package com.perion.aop_lab;

/**
 * @author Evgeny Borisov
 */
public class DBRuntimeException extends RuntimeException {
    public DBRuntimeException(String message) {
        super(message);
    }
}
