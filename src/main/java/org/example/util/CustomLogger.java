package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.factory.ObjectMapperFactory;
import org.example.model.log.Log;

public class CustomLogger {

//    private final ObjectMapper objectMapper;
//
//    public CustomLogger() {
//        this.objectMapper = ObjectMapperFactory.createObjectMapper();
//    }
//
//    public void log(String message, Object payload) {
//        try {
//            String jsonPayload = objectMapper.writeValueAsString(payload);
//            System.out.println("Log Message: " + message);
//            System.out.println("Payload: " + jsonPayload);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }

//    private final ObjectMapper objectMapper;
//
//    public CustomLogger() {
//        this.objectMapper = ObjectMapperFactory.createObjectMapper();
//    }
//
//    public void log(String message, Object payload) {
//        try {
//            String jsonPayload = objectMapper.writeValueAsString(payload);
//
//            // Cria o objeto Result
//            Log result = new Log(message, jsonPayload);
//
//            // Serializa o objeto Result
//            String resultJson = objectMapper.writeValueAsString(result);
//
//            System.out.println(resultJson);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }



    private final ObjectMapper objectMapper;

    public CustomLogger() {
        this.objectMapper = ObjectMapperFactory.createObjectMapper();
    }

    public void log(String message, Object payload) {
        try {
            // Cria o objeto Result com o payload original
            Log result = new Log(message, payload);

            // Serializa o objeto Result
            String resultJson = objectMapper.writeValueAsString(result);

            System.out.println(resultJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
