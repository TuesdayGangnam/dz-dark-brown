package com.dz.exceptions;

import com.dz.constant.ResponseCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LogicExcepion extends RuntimeException implements InternalException{

    private String httpCode;
    private String httpMessage;

    private LogicExcepion(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.httpCode = responseCode.getCode();
        this.httpMessage = responseCode.getMessage();
        getHttpInfo();
    }

    public static LogicExcepion internalException(ResponseCode responseCode) {

        return new LogicExcepion(responseCode);
    }

    @Override
    public Map<String, String> getHttpInfo() {
        Map<String, String> returnHttpInfo = new HashMap<>();
        returnHttpInfo.put("httpCode", this.getHttpCode());
        returnHttpInfo.put("httpMessage", this.getHttpMessage());
        return returnHttpInfo;
    }
}

