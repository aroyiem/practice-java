package com.practice.collections.sort;

public class BubbleSort {

    // time complexity O(n*n)
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;


        for(int i = 0; i< n; i++ ) {
            for(int j = 1; j< n; j++ ) {
                if(arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 50, 30, 10, 60, 80};
        System.out.println("Before sort");
        print(arr);
        bubbleSort(arr);
        System.out.println("After sort");
        print(arr);
    }

    static void print(int[] arr) {
        for(int i = 0; i< arr.length; i++ ) {
            System.out.print(arr[i] + "\t");
        }
    }
}
