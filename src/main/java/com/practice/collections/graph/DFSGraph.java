package com.practice.collections.graph;

public class DFSGraph {

    int size;
    AdjacentList[] array;

    public DFSGraph(int size) {
        this.size = size;
        array= new AdjacentList[this.size];
        for(int i = 0; i < size; i++) {
            array[i] = new AdjacentList();
            array[i].head = null;
        }
    }

    public void add(int src, int dest) {
        Node n = new Node(dest, null);
        n.next = array[src].head;
        array[src].head = n;
    }

    class RunThread extends Thread {
        @Override
        public void run() {
            super.run();
        }

        @Override
        public synchronized void start() {
            super.start();
        }
    }
}
