package com.dz.exceptions;

public class JsonException extends RuntimeException {

    private JsonException(String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
    }

    public static JsonException serialize(Object target, Exception exception) {
        return new JsonException("serialize exceptions target   =" + target, exception);
    }

    public static JsonException deserialize(String target, Exception exception) {
        return new JsonException("deserialize exceptions target =" + target, exception);
    }
}