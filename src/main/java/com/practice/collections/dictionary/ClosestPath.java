package com.practice.collections.dictionary;

import java.util.Stack;

public class ClosestPath {

    public static void main(String[] args) {
        String[] dictionary = {"hot", "dot", "dog", "lot", "log", "cog"};
        String startWord = "hit";
        String endWord = "cog";

        boolean isFound = new ClosestPath().findPath(dictionary, startWord, endWord);
        System.out.println("isFound:: " + isFound);
    }

    boolean findPath(String[] dictionary, String startWord, String endWord) {
        boolean isFound = false;
        boolean[] isVisited = new boolean[dictionary.length];

        Stack<String> stack = new Stack<>();
        stack.push(startWord);

        while(!stack.isEmpty()) {
            String word = stack.pop();
            if(distance(word, endWord) == 0) {
                stack.push(word);
                System.out.println(stack);
                isFound = true;
                break;
            }

            for(int i = 0; i< dictionary.length; i++) {
                if(isVisited[i]) {
                    continue;
                }

                if(distance(word, dictionary[i]) == 1) {
                    stack.push(word);
                    stack.push(dictionary[i]);
                    isVisited[i] = true;
                    break;
                }

            }
        }

        return isFound;
    }

    int distance(String word, String endWord) {
        int distance = 3;
        for(int i= 0; i< word.length(); i++) {
            if (word.charAt(i) == endWord.charAt(i)) {
                distance--;
            }
        }
        return distance;
    }
}
