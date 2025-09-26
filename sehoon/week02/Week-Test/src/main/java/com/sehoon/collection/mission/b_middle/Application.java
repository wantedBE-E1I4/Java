package com.sehoon.collection.mission.b_middle;

import com.ohgiraffers.collection.mission.b_middle.service.LottoMaker;

public class Application {
    public static void main(String[] args) {
        LottoMaker lottoMaker = new LottoMaker();

        lottoMaker.makeNumers();
        lottoMaker.printNumbers();
    }
}
