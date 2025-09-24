package com.sehoon.oop.mission.c_deep;

import com.sehoon.oop.mission.c_deep.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {

        // 1. sum하기
        CollectionUtils collectionUtils = new CollectionUtils();
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.0);
        doubleList.add(2.0);

        double result1 = collectionUtils.sum(intList);
        System.out.println(result1);

        double result2 = collectionUtils.sum(doubleList);
        System.out.println(result2);

        // 2. 리스트에 int 값 넣기
        List<Integer> list = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        System.out.println("=== Integer 리스트 확인 ===");
        collectionUtils.addIntegers(list,10);
        System.out.println(list);

        System.out.println("=== Number 리스트 확인 ===");
        collectionUtils.addIntegers(numberList,10);
        System.out.println(numberList);

        System.out.println("=== Object 리스트 확인 ===");
        collectionUtils.addIntegers(objectList,10);
        System.out.println(objectList);


    }
}
