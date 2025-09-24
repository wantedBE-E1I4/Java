package com.sehoon.oop.mission.b_middle.model.converter;

public class StringToIntegerConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            // null을
            throw new NumberFormatException();
        }
    }
}
