/* 
 * ============================================================================ 
 * Name      : Author.java
 * ============================================================================
 */
package com.agisoft.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Author {

    String name() default "kris";

    String company() default "agisoft";
}
