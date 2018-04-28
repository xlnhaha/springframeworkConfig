package com.smart.condition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Conditional(MyConditional.class)
public @interface IfExist {
	Class<?> value();
}
