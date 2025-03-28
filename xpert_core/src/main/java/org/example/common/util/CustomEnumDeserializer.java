package org.example.common.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Arrays;

public class CustomEnumDeserializer extends StdDeserializer<Enum<?>> implements ContextualDeserializer {

    public CustomEnumDeserializer () {
        this(null);
    }

    protected CustomEnumDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    @SuppressWarnings("uncheked value")
    public Enum<?> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode jsonNode = parser.getCodec().readTree(parser);
        String enumValue = jsonNode.asText();
        if (enumValue == null) return null;
        Class<? extends Enum> enumType = (Class<? extends Enum>) this._valueClass;

        return Arrays.stream(enumType.getEnumConstants())
                .filter(constant -> enumValue.equals(constant.name()))
                .findAny()
                .orElse(null);
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext context, BeanProperty property) {
        return new CustomEnumDeserializer(property.getType().getRawClass());
    }
}
