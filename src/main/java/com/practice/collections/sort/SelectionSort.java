package com.practice.collections.sort;

public class SelectionSort {

    // time complexity O(n*n)
    static void selectionSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i< n; i++ ) {
            int index = i;
            for(int j = i + 1; j< n; j++ ) {
                if(arr[j] < arr[index]) {
                    index = j;
                }
            }
            if(index != i) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 50, 30, 10, 60, 80};
        System.out.println("Before sort");
        print(arr);
        selectionSort(arr);
        System.out.println("After sort");
        print(arr);
    }

    static void print(int[] arr) {
        for(int i = 0; i< arr.length; i++ ) {
            System.out.print(arr[i] + "\t");
        }
    }
}
