package com.practice.collections;

public class SpiralMatrix {


    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        new SpiralMatrix().printSpiral(array);
    }

    void printSpiral(int[][] array) {
        int firstRow = 0;
        int lastRow = array.length - 1;
        int firstCol = 0;
        int lastCol = array[0].length - 1;

        while (firstRow < lastRow && firstCol < lastCol) {
            // left to right
            for (int i = firstCol; i <= lastCol; i++) {
                System.out.println(array[firstCol][i]);
            }

            // top to bottom
            for(int i = firstRow + 1; i <= lastRow; i++) {
                System.out.println(array[i][lastCol]);
            }

            // right to left
            for(int i = lastCol - 1; i >= firstCol; i--) {
                System.out.println(array[lastRow][i]);
            }

            // bottom to top
            for(int i = lastRow - 1; i > firstRow; i--) {
                System.out.println(array[i][firstCol]);
            }

            firstRow++;
            lastRow--;
            firstCol++;
            lastCol--;
        }
    }
}
