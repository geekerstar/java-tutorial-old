package com.geekerstar.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

/**
 * @author geekerstar
 * date: 2019/9/15 13:10
 * description:
 */
@Data
public class DataExample {
    private final String name;

    @Setter(AccessLevel.PACKAGE)
    private int age;

    private Double score;

    private String[] tags;

    @ToString(includeFieldNames = true)
    @Data(staticConstructor = "of")
    public static class Exercise<T>{
        private final String name;
        private final T value;
    }
}
