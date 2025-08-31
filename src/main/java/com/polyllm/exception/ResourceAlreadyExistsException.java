package com.polyllm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends PolyLLMException {


    @Serial
    private static final long serialVersionUID = 8345063695560802109L;

    public ResourceAlreadyExistsException(String resourceName, String fieldName, Serializable fieldValue) {
        super("already exists", resourceName, fieldName, fieldValue);
    }
}
