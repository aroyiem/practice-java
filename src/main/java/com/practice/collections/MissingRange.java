package com.practice.collections;

public class MissingRange {

    public static void main(String[] args) {
        int[] input = {0, 2, 50, 52, 75};
        int lowerLimit = 0;
        int upperLimit = 99;

        StringBuilder str = new StringBuilder();
        int firstElement;
        int secondElement;
        for (int i = 0; i < input.length; i++) {
            // check for the first element
            if (i == 0 && input[i] != lowerLimit) {
                firstElement = lowerLimit - 1;
                secondElement = input[i];
            } else {
                firstElement = input[i];
                if (i == input.length - 1) {
                    // end of the input array
                    secondElement = upperLimit + 1;
                } else {
                    secondElement = input[i + 1];
                }
            }

            if (secondElement - firstElement == 2) {
                str.append(firstElement + 1).append(",");
            } else if (secondElement - firstElement > 2) {
                str.append(firstElement + 1).append("-").append(secondElement - 1).append(",");
            }
        }
        str.deleteCharAt(str.length() -1);
        System.out.println(str);
    }
}
