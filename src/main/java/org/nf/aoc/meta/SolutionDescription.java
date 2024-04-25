package org.nf.aoc.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SolutionDescription {

    int year();

    int day();

    int part();

    String description();

    String link();

    String[] tags() default "";
}
