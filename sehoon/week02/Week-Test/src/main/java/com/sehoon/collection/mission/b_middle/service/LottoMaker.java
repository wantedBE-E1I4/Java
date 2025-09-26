package com.sehoon.collection.mission.b_middle.service;

import java.util.*;

public class LottoMaker {
    Set<Integer> lottoSet = new HashSet<>();

    public void makeNumers() {

        while (this.lottoSet.size() < 7) {
            double num = (Math.random() * 45)  + 1;
            this.lottoSet.add((int) num);

        }
    }

    public void printNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(this.lottoSet);
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
