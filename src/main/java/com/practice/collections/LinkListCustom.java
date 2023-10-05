package com.practice.collections;

import java.util.Objects;

public class LinkListCustom<T> {
    Node head;

    public LinkListCustom() {
        head = null;
    }

    public void add(Object value) {
        Node node = new Node(value, null);
        if(head == null) {
            head = node;
        } else {
            // add at the beginning
            node.next = head;
            head = node;
        }
    }

    public void delete() {
        head = head.next;
    }

    public void display() {
        Node n = head;
        while(n != null) {
            System.out.print((T)n.value + " ");
            n = n.next;
        }
    }
}
