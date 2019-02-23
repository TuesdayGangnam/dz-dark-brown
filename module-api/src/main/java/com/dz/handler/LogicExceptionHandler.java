package com.dz.handler;

import com.dz.exceptions.InternalException;
import com.dz.exceptions.CustomLogicExcepion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static com.dz.constant.ResponseAttribute.SERVER_CODE;
import static com.dz.constant.ResponseAttribute.SERVER_MESSAGE;

@ControllerAdvice
public class LogicExceptionHandler {

    private static String HTTP_CODE = "httpCode";
    private static String HTTP_MESSAGE = "httpMessage";

    @ExceptionHandler(CustomLogicExcepion.class)
    public ResponseEntity fail(CustomLogicExcepion customLogicExcepion) {
        return ResponseEntity.ok(getFailCodeMsgResult(customLogicExcepion));
    }

    private static Map<String, Object> getFailCodeMsgResult(InternalException internalException) {
        Map<String, Object> responseResult = new HashMap<>();
        responseResult.put(SERVER_CODE.getResponseKey(), internalException.getHttpInfo().get(HTTP_CODE));
        responseResult.put(SERVER_MESSAGE.getResponseKey(), internalException.getHttpInfo().get(HTTP_MESSAGE));
        return responseResult;
    }

}
