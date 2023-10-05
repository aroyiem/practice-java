package com.practice.collections;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        String input = "aabbbc";

        int index = Integer.MIN_VALUE;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int count = charMap.getOrDefault(c, 0);
            count++;
            charMap.put(c, count);
            if(count > maxLength) {
                maxLength = count;
                index = i;
            }
        }
        index = (index + 1) - maxLength;
        System.out.println("Max length " + maxLength);
        System.out.println("Index " + index);
    }
}
