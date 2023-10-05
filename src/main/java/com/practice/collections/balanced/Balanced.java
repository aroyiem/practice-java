package com.practice.collections.balanced;

import java.util.Stack;

public class Balanced {

    public static void main(String[] args) {
        String input = "({[]()})";

        System.out.println(new Balanced().isBalanced(input) ? "Balanced" : "Unbalanced");
    }

    boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i< input.length(); i++) {
            char x = input.charAt(i);
            if(x == '(' || x == '{' || x == '[') {
                stack.push(x);
            }

            if(stack.empty()) {
                return false;
            }
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if(check == '}' || check == ']') {
                        return false;
                    }
                    break;
                case '}':
                    check = stack.pop();
                    if(check == ')' || check == ']') {
                        return false;
                    }
                    break;
                case ']':
                    check = stack.pop();
                    if(check == '}' || check == ')') {
                        return false;
                    }
                    break;
            }
        }
        return stack.empty();
    }
}
