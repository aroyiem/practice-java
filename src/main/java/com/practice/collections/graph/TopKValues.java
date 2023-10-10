package com.practice.collections.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TopKValues {

    public static void main(String[] args) {
        int k = 4;
        Queue<Integer> lastKValues = new LinkedList<>();
        Set<Integer> uniqueValues = new HashSet<>();

        // Initial collection
        int[] initialCollection = {1, 2, 3, 4, 5};
        for (int val : initialCollection) {
            addValue(val, lastKValues, uniqueValues, k);
        }

        // Simulate new values
        /*int[] newValues = {5, 2, 6};
        for (int val : newValues) {
            addValue(val, lastKValues, uniqueValues, k);
        }*/
    }

    public static void addValue(int value, Queue<Integer> lastKValues, Set<Integer> uniqueValues, int k) {
        if (!uniqueValues.contains(value)) {
            if (lastKValues.size() >= k) {
                int removedValue = lastKValues.poll();
                uniqueValues.remove(removedValue);
            }
            lastKValues.offer(value);
            uniqueValues.add(value);
        }

        // Print the top k values
        System.out.println("Top " + k + " values: " + lastKValues);
    }
}
