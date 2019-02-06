package com.dz.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResponseAttribute {

    SERVER_CODE("code"),
    SERVER_MESSAGE("message"),
    RESULTS("results");

    String responseKey;

    public String getResponseKey(){
        return this.responseKey;
    }

}