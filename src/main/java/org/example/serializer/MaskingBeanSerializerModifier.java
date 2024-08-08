package org.example.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import org.example.annotation.Mask;

import java.util.List;

public class MaskingBeanSerializerModifier extends BeanSerializerModifier {


    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
                                                     List<BeanPropertyWriter> beanProperties) {
        for (int i = 0; i < beanProperties.size(); i++) {
            BeanPropertyWriter writer = beanProperties.get(i);
            if (writer.getAnnotation(Mask.class) != null) {
                beanProperties.set(i, new MaskingBeanPropertyWriter(writer));
            }
        }
        return beanProperties;
    }

    private static class MaskingBeanPropertyWriter extends BeanPropertyWriter {
        private final BeanPropertyWriter delegate;

        public MaskingBeanPropertyWriter(BeanPropertyWriter delegate) {
            super(delegate);
            this.delegate = delegate;
        }

        @Override
        public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {
            Object value = delegate.get(bean);
            Mask maskAnnotation = delegate.getAnnotation(Mask.class);
            if (maskAnnotation != null && value != null) {
                String maskedValue = maskValue(value.toString(), maskAnnotation.value());
                gen.writeStringField(delegate.getName(), maskedValue);
            } else {
                delegate.serializeAsField(bean, gen, prov);
            }
        }

        private String maskValue(String value, char maskChar) {
            return value.replaceAll(".", String.valueOf(maskChar));
        }
    }

}
