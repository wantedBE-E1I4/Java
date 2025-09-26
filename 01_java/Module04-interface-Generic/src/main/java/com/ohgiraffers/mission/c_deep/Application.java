package com.ohgiraffers.mission.c_deep;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        List<Integer> integerList = new ArrayList<>();
        app.addIntegers(integerList, 3);

        List<Number> numberList = new ArrayList<>();
        app.addIntegers(numberList, 3);

        List<Object> objectList = new ArrayList<>();
        app.addIntegers(objectList,3);
    }

    private void addIntegers(List<? super Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }
}
