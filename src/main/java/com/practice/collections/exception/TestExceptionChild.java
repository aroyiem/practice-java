package com.practice.collections.exception;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.IntStream;

public class TestExceptionChild extends Parent {
    // overriding the method in child class
    // gives compile time error
    /*void msg() throws IOException {
        System.out.println("TestExceptionChild");
    }*/

    void msg() throws ArithmeticException {
        System.out.println("child method");
    }

    /*void msg1()throws Exception {
        System.out.println("child method");
    }*/

    public static void main(String args[]) {
       /* Parent p = new TestExceptionChild();
        p.msg();*/
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put(null, null);
        System.out.println(map);

        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 20).forEach(c -> list.add(c));
        System.out.println(list.subList(0, 10));
    }

}
