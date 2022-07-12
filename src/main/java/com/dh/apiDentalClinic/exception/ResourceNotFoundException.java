package com.dh.apiDentalClinic.exception;



import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException {

    private String name;
    private String fieldName;
    private String message;

    public ResourceNotFoundException(String name, String fieldName, String message) {
        this.name = name;
        this.fieldName = fieldName;
        this.message = message;
    }

    public ResourceNotFoundException(String message, String name, String fieldName, String message1) {
        super(message);
        this.name = name;
        this.fieldName = fieldName;
        this.message = message1;
    }

    public ResourceNotFoundException(String message, Throwable cause, String name, String fieldName, String message1) {
        super(message, cause);
        this.name = name;
        this.fieldName = fieldName;
        this.message = message1;
    }

    public ResourceNotFoundException(Throwable cause, String name, String fieldName, String message) {
        super(cause);
        this.name = name;
        this.fieldName = fieldName;
        this.message = message;
    }

    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String name, String fieldName, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.name = name;
        this.fieldName = fieldName;
        this.message = message1;
    }
}