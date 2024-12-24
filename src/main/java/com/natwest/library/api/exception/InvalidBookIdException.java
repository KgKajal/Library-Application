package com.natwest.library.api.exception;

public class InvalidBookIdException extends RuntimeException {

    public InvalidBookIdException(String msg){
        super(msg);
    }
}
