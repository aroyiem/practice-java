package com.practice.collections.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * In this program:
 *
 * We define an array songDurations that contains the durations of songs in minutes.
 * The findPairs function takes the array of song durations and the target duration (in this case, 120 minutes) as input.
 * We use a HashMap called durationCounts to keep track of the count of each duration encountered.
 * We iterate through the array of song durations, calculating the complement (the duration that would make the sum 120 minutes).
 * If the complement is found in the durationCounts map and its count is greater than 0, we print the pair and decrement the count for both durations to mark them as used.
 * If the complement is not found, we increment the count for the current duration.
 * When you run this program with the provided songDurations, it will find and print the unique pairs of songs whose durations sum up to 120 minutes or a multiple of 120 minutes.
 */

public class SongPair {

    public static void main(String[] args) {
        int[] songDurations = {30, 40, 50, 40, 60, 70, 80};

        findPairs(songDurations, 120);
    }

    public static void findPairs(int[] durations, int target) {
        Map<Integer, Integer> durationCounts = new HashMap<>();

        for (int duration : durations) {
            int complement = target - duration;

            if (durationCounts.containsKey(complement) && durationCounts.get(complement) > 0) {
                System.out.println("Pair found: (" + duration + ", " + complement + ")");
                // Mark the pair as used
                int freq = durationCounts.getOrDefault(duration, 0);
                if(freq > 0) {
                    freq--;
                }
                durationCounts.put(duration, freq);
                durationCounts.put(complement, durationCounts.get(complement) - 1);
            } else {
                // Increment the count for this duration
                durationCounts.put(duration, durationCounts.getOrDefault(duration, 0) + 1);
            }
        }
    }
}
