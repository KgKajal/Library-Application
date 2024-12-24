package com.natwest.library.api.exceptionhandler;

public record ErrorResponse (String msg, int statusCode, long timestamp){
}
