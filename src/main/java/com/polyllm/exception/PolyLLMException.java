package com.polyllm.exception;

import java.io.Serial;
import java.io.Serializable;

public abstract class PolyLLMException extends Exception {


    @Serial
    private static final long serialVersionUID = -2430218595812285955L;

    private final String resourceName;
    private final String fieldName;
    private final Serializable fieldValue;

    protected PolyLLMException(String msg, String resourceName, String fieldName, Serializable fieldValue) {
        super(String.format("%s %s %s : '%s'", resourceName, msg, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Serializable getFieldValue() {
        return fieldValue;
    }

}
