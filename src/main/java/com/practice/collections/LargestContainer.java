package com.practice.collections;

public class LargestContainer {

    public static void main(String[] args) {
        int area = new LargestContainer().largestContainer(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println("area = " + area);
    }

    int largestContainer(int[] array) {
        int maxArea = Integer.MIN_VALUE;
        int begin = 0;
        int end = array.length - 1;

        while (begin < end) {
            int width = end - begin;
            int height = Math.min(array[begin], array[end]);
            int area = width * height;
            maxArea = Math.max(maxArea, area);

            if(array[begin] < array[end]) {
                begin++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
}
