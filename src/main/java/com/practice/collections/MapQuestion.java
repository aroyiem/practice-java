package com.practice.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapQuestion {

    public static void main(String[] args) {
        String text = "Bob hit a ball the hit ball flew far after it was hit";
        String freq = new MapQuestion().getMostCommonWOrd(text);
        System.out.println("F = " + freq);

        String input = "abcdefg";

        boolean hasDuplicates = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet())
                .size() < input.length();

        if (hasDuplicates) {
            System.out.println("The string has duplicate characters.");
        } else {
            System.out.println("The string does not have duplicate characters.");
        }


    }

    String getMostCommonWOrd(String text) {
        String[] words = text.split(" ");
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(words).forEach(word -> {
            int freq = map.getOrDefault(word, 0);
            freq++;
            map.put(word, freq);
        });

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            int value = entry.getValue();
            if(value > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        return maxKey;
    }
}
