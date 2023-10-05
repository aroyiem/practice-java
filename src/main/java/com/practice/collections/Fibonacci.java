package com.practice.collections;

import java.util.stream.IntStream;

public class Fibonacci {

    // f(n) = f(n - 1) + f(n - 2)
    /*
    0 1 1 2 3 5 8 13 21 34
     */

    static void fibonacciNormal(int n) {
        int first = 0, second = 1;
        for(int index = 1; index <= n; index++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }

    static void fibonacciRecursive(int n) {
        IntStream.range(0, n).forEach(c -> System.out.print(printRecursive(c) + " "));
    }

    static int printRecursive(int range) {
        if(range == 0 || range == 1) {
            return range;
        }
        return printRecursive(range -1) + printRecursive(range - 2);
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci normal => ");
        long startTime = System.currentTimeMillis();
        fibonacciNormal(10);
        System.out.println("Normal time taken in millis " + (System.currentTimeMillis() - startTime));
        System.out.println("\n Fibonacci recursive => ");
        startTime = System.currentTimeMillis();
        fibonacciRecursive(10);
        System.out.println("Recursive time taken in millis " + (System.currentTimeMillis() - startTime));
    }
}
