package org.example.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.example.serializer.MaskingBeanSerializerModifier;

public class ObjectMapperFactory {

    public static ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.setSerializerModifier(new MaskingBeanSerializerModifier());
        objectMapper.registerModule(module);
        return objectMapper;
    }

}
