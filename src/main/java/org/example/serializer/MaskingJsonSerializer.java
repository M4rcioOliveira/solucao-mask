package org.example.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.example.annotation.Mask;

import java.io.IOException;

public class MaskingJsonSerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }

        Class<?> clazz = value.getClass();
        Mask maskAnnotation = clazz.getAnnotation(Mask.class);
        if (maskAnnotation != null) {
            String maskedValue = maskValue(value.toString(), maskAnnotation.value());
            gen.writeString(maskedValue);
        } else {
            gen.writeObject(value);
        }
    }

    private String maskValue(String value, char maskChar) {
        return value.replaceAll(".", String.valueOf(maskChar));
    }
}
