package com.practice.collections.staircase;

import java.util.ArrayList;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        Stack<Stair> stairStack = new Stack<>();
        int steps = 4;

        Stair stair = new Stair(0, new ArrayList<>());
        stairStack.add(stair);

        while(!stairStack.empty()) {
            Stair currentStair = stairStack.pop();
            if(currentStair.getNumber() == steps) {
                System.out.println(currentStair.getVisited());
                continue;
            }

            int oneStair = currentStair.getNumber() + 1;
            if(oneStair <= steps) {
                stairStack.add(new Stair(oneStair, currentStair.getVisited()));
            }

            int twoStair = currentStair.getNumber() + 2;
            if(twoStair <= steps) {
                stairStack.add(new Stair(twoStair, currentStair.getVisited()));
            }
        }
    }
}
