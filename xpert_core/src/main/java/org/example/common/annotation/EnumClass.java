package org.example.common.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.example.common.util.CustomEnumDeserializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotationsInside
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@JsonDeserialize(using = CustomEnumDeserializer.class)
public @interface EnumClass {
}
