package com.sehoon.collection.mission.c_deep;

import com.ohgiraffers.collection.mission.c_deep.service.WordFrequencyAnalyzer;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // 문장 정의
        String sentence = "asdasd adsd ad asd asdad asd";

        // 단어 분류기 생성
        WordFrequencyAnalyzer wf = new WordFrequencyAnalyzer();

        // 딘어 분류 수행
        Map<String, Integer> classifiedWords =  wf.analyzer(sentence);

        // for-each문
        for (Map.Entry<String, Integer> entry : classifiedWords.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }



        System.out.println("=== 테스트 ===");
        String newSentence = "asdasd adsd ad asd asdad asd";
        Map<String, Integer> classifiedWords2 =  wf.analyzer(newSentence);
        for (Map.Entry<String, Integer> entry : classifiedWords2.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
