package com.six.annotation;

import java.lang.annotation.*;

/**
 * Annotation Hello World.
 * Created by Xiaolin on 2016-07-07.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface HelloAnnotation {
    String greeting() default "Hello World";
}
