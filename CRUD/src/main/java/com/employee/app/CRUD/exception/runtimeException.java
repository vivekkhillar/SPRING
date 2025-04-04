package com.employee.app.CRUD.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class runtimeException extends RuntimeException{

    public runtimeException(String message){
        super(message);
    }
}
