package com.natwest.library.api.exception;

public class InvalidBookNameException extends RuntimeException{

    public InvalidBookNameException(String msg){
        super(msg);
    }
}
