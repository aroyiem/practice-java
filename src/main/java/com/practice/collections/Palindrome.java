package com.practice.collections;

public class Palindrome {

    private static final String palindrome = "dog";

    public static boolean isPalindrome(String input) {
        // reverse the string
        char[] chars = input.toCharArray();
        char[] reverseChars = new char[chars.length];

        for(int i = chars.length -1,  j = 0; i >= 0; i --, j++) {
            reverseChars[j] = chars[i];
        }
        return String.valueOf(reverseChars).equals(input);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(palindrome));
    }
}
