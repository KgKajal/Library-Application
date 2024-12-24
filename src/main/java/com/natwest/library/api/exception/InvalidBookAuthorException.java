package com.natwest.library.api.exception;

public class InvalidBookAuthorException extends RuntimeException{

    public InvalidBookAuthorException(String msg){
        super(msg);
    }
}
