package com.practice.collections.staircase;

import java.util.ArrayList;
import java.util.List;

public class Stair {
    private int number;
    private List<Integer> visited = new ArrayList<>();

    public Stair(int number, List<Integer> visited) {
        this.number = number;
        this.visited.addAll(visited);
        this.visited.add(this.number);
    }

    public int getNumber() {
        return number;
    }

    public List<Integer> getVisited() {
        return visited;
    }
}
