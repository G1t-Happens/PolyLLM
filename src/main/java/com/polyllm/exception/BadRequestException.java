package com.polyllm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends PolyLLMException {


    @Serial
    private static final long serialVersionUID = -9110538031737589515L;

    public BadRequestException(String resourceName, String fieldName, Serializable fieldValue) {
        super("bad request for", resourceName, fieldName, fieldValue);
    }
}
