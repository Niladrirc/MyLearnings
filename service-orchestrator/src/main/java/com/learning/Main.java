package com.learning;


@FunctionalInterface
interface A {
    void show();
}

interface B {
    void show();
    int add(int a, int b);
}


public class Main {
    public static void main(String[] args) {
        // Using Anonymous Inner class
        A aObj1 = new A() {
            @Override
            public void show() {
                System.out.println("Hello");
            }
        };

        B bObj1 = new B() {
            @Override
            public void show() {
                System.out.println("Hello");
            }

            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };

        // Using lambda expressions
        A aObj2 =  () -> System.out.println("Hello");

    }
}