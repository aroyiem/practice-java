package com.practice.collections;

public class LinkedListManager {

    public static void main(String[] args) {
        LinkListCustom<Integer> ls = new LinkListCustom<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls.add(6);

        ls.display();
        deleteKthElement(ls, 2);
        System.out.println();
        ls.display();
    }

    public static void deleteKthElement(LinkListCustom<Integer> ls, int k) {
        Node root = ls.head;
        Node sp = root;
        Node fp = root;

        // move the fp fp = sp + k
        while(k > 0) {
            fp = fp.next;
            k--;
        }

        // move sp & fp sequentially till fp reach the end of the queue
        while(fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next;
        }

        // delete the node
        // first element needs to be deleted
        if(root == sp) {
           ls.head = sp.next;
        } else {
            sp.next = sp.next.next;
        }

    }
}
