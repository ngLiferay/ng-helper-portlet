package com.liferaying.invoke;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})

/**
 * Annotation must be used with methods to use services and generate ngResource api.
 * @author Yogesh Agarwal
 *
 */
public @interface MethodParams {
	String[] names();
}
