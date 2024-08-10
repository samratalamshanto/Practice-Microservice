package com.application.apigateway.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.ObjectUtils;

import java.time.format.DateTimeFormatter;

public class Utility {
    public static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String objectToJsonString(Object object) {
        if (ObjectUtils.isEmpty(object)) {
            return "null";
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            return "null";
        }
    }


}
