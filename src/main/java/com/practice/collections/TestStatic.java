package com.practice.collections;

public class TestStatic {

    private static String str = "Hello";

    private String str2;

    public TestStatic(String str) {
        this.str = str;
        str2 = "World";
        System.out.println("CONSTRUCTOR: " + str + " " + str2);
    }

    static {
        TestStatic t = new TestStatic("Goodbye");
        str = "Hello";
        System.out.println("STATIC: " + str + " " + t.str2);
    }

    public static void main(String[] args) {

        TestStatic test = new TestStatic("Another");
        test.str = "Last";
        System.out.println("MAIN: " + test.str + " " + test.str2);
    }
}
