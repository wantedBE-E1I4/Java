package com.sehoon.collection.mission.c_deep.service;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyAnalyzer {
    private Map<String, Integer> dict;


    public Map<String, Integer> analyzer(String sentence) {
        this.dict = new HashMap<>();

        String[] words = sentence.split("\\s+");

        for (String word : words) {
            if (word.equals(" ")) continue;
            String replacedWord = word.replaceAll("[^a-zA-Z\n]", "").toLowerCase();

            this.dict.put(replacedWord, this.dict.getOrDefault(replacedWord, 0) + 1);
        }

        return this.dict;
    }
}
