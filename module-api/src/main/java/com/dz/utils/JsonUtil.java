package com.dz.utils;

import com.dz.exceptions.JsonException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String toJson(Object target) {
        try {
            return OBJECT_MAPPER.writeValueAsString(target);
        } catch (IOException e) {
            throw JsonException.serialize(target, e);
        }
    }

    public static <T> T fromJson(String target, Class<T> tClass) {
        try {
            return OBJECT_MAPPER.readValue(target, tClass);
        } catch (IOException e) {
            throw JsonException.deserialize(target, e);
        }
    }
}
