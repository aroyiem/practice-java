package com.practice.collections.sort;

public class QuickSort {

    // time complexity O(n*n)
    static void quickSort(int[] arr, int low, int high) {

        if(low > high) {
            return;
        }
        int mid = low + ((high - low)/2);
        int pivot = arr[mid];

        int i =low;
        int j=high;
        while(i<=j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if(i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if(low < j) {
            quickSort(arr, low, j);
        }
        if(high > i) {
            quickSort(arr, i, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 50, 30, 10, 60, 80};
        System.out.println("Before sort");
        print(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After sort");
        print(arr);
    }

    static void print(int[] arr) {
        for(int i = 0; i< arr.length; i++ ) {
            System.out.print(arr[i] + "\t");
        }
    }
}
