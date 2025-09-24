package com.sehoon.oop.mission.c_deep.util;

import java.util.List;

public class CollectionUtils {
    public double sum(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public void addIntegers(List<? super Integer> list, int n) {
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

    }
}
