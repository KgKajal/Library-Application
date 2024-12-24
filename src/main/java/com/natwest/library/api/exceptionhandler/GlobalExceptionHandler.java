package com.natwest.library.api.exceptionhandler;

import com.natwest.library.api.exception.BookOutOfStockException;
import com.natwest.library.api.exception.InvalidBookAuthorException;
import com.natwest.library.api.exception.InvalidBookIdException;
import com.natwest.library.api.exception.InvalidBookNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookOutOfStockException.class)
    public ResponseEntity<ErrorResponse> handleBookOurOfStockException(BookOutOfStockException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value(), System.currentTimeMillis());
        return  new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidBookIdException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBookIdException(InvalidBookIdException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidBookNameException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBookNameException(InvalidBookNameException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidBookAuthorException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBookNameException(InvalidBookAuthorException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
