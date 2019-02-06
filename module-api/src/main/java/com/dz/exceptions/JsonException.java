package com.dz.exceptions;

import com.dz.constant.ResponseCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class JsonException extends RuntimeException implements InternalException {

    private String httpCode;
    private String httpMessage;

    private JsonException(ResponseCode responseCode, String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
        this.httpCode = responseCode.getCode();
        this.httpMessage = responseCode.getMessage();
        getHttpInfo();
    }

    public static JsonException serialize(ResponseCode responseCode, Object target, Exception exception) {
        return new JsonException(responseCode, "serialize exceptions target   =" + target, exception);
    }

    public static JsonException deserialize(ResponseCode responseCode, String target, Exception exception) {
        return new JsonException(responseCode, "deserialize exceptions target =" + target, exception);
    }

    @Override
    public Map<String, String> getHttpInfo() {
        Map<String, String> returnHttpInfo = new HashMap<>();
        returnHttpInfo.put("httpCode", this.getHttpCode());
        returnHttpInfo.put("httpMessage", this.getHttpMessage());
        return returnHttpInfo;

    }
}