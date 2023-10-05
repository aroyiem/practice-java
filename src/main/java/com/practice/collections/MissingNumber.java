package com.practice.collections;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MissingNumber {

    static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20};

    static int findMissingNumber(int[] nums) {
        System.out.println("printing un-sorted array");
        Arrays.stream(nums).forEach(c -> System.out.print(c + " "));
        //return 0;

        int[] copy = Arrays.copyOf(nums, numbers.length);

        System.out.println("\nprinting sorted array");
        Arrays.parallelSort(copy);
        Arrays.stream(copy).forEach(c -> System.out.print(c + " "));

        // take sum of all n numbers, add it by 1 because 1 is missing sum = (n * (n + 1))/2
        int length = copy.length + 1;

        int sum = (length * (length + 1)) / 2;

        int sumOfOriginalArray = Arrays.stream(copy).reduce(0, (x, y) -> x + y);

        return sum - sumOfOriginalArray;
    }

    public static void main(String[] args) {
        System.out.println("\nMissing element " + findMissingNumber(numbers));
    }
}
