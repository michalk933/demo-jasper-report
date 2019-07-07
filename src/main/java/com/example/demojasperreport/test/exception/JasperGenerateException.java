package com.example.demojasperreport.test.exception;


/**
 * Exception jasper report
 *
 * Create by Michał Kuchciak
 */
public class JasperGenerateException extends RuntimeException {

    public JasperGenerateException(String msg) {
        super(msg);
    }

    public JasperGenerateException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
