package com.practice.collections;

public class LongestOne {

    public static void main(String[] args) {
        int len = new LongestOne().longestOnes(new int[]{0, 1, 1, 0, 1, 0, 0});
        System.out.println("len = " + len);
    }

    int longestOnes(int[] array) {
        int longOnes = Integer.MIN_VALUE;
        int beforeZero = 0;
        int afterZero = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] == 1) {
                afterZero++;
            } else {
                longOnes = Math.max(longOnes, beforeZero + afterZero + 1);
                beforeZero = afterZero;
                afterZero = 0;
            }
        }
        longOnes = Math.max(longOnes, beforeZero + afterZero + 1);
        return longOnes;
    }
}
