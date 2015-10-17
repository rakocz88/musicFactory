package com.pilaf.musicFactory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
public @interface Describe {

	public boolean enabled() default true;

	public String createdBy();

	Priority priority() default Priority.MEDIUM;

	public enum Priority {
		LOW, MEDIUM, HIGH
	}

}
