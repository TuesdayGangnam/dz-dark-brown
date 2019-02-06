package com.dz.constant;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.dz.constant.ResponseAttribute.*;

public class ResponseSuccess {

    private ResponseSuccess(){}

    private static Map<String,Object> getOkCodeMsgResult() {
        Map<String,Object> responseResult = new HashMap<>();
        responseResult.put(SERVER_CODE.getResponseKey(), ResponseCode.OK.getCode());
        responseResult.put(SERVER_MESSAGE.getResponseKey(), ResponseCode.OK.getMessage());
        return responseResult;
    }

    public static ResponseEntity success(){
        return ResponseEntity.ok(getOkCodeMsgResult());
    }

    public static ResponseEntity success(Map<String,Object> result){
        Map<String,Object> responseResult = getOkCodeMsgResult();
        responseResult.put(RESULTS.getResponseKey(), result);

        return ResponseEntity.ok(responseResult);
    }

    public static ResponseEntity success(List<Map> results){
        Map<String,Object> responseResult = getOkCodeMsgResult();
        responseResult.put(RESULTS.getResponseKey(), results);

        return ResponseEntity.ok(responseResult);
    }
}
