package com.polyllm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends PolyLLMException {


    @Serial
    private static final long serialVersionUID = 4269740568476753821L;

    public ResourceNotFoundException(String resourceName, String fieldName, Serializable fieldValue) {
        super("not found with", resourceName, fieldName, fieldValue);
    }
}
