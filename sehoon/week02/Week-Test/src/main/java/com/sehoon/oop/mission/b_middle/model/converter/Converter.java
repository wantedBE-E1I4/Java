package com.sehoon.oop.mission.b_middle.model.converter;

public interface Converter<T,R> {
    R convert(T t);
}
