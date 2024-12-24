package com.natwest.library.api.exception;

public class BookOutOfStockException extends RuntimeException{

    public BookOutOfStockException(String msg){
        super(msg);
    }
}
