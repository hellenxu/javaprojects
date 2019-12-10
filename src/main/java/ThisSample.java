package main.java;

import java.util.function.Consumer;

/**
 * @author hellenxu
 * @date 2019-08-14
 * Copyright 2019 Six. All rights reserved.
 */
class A {
    private String name = "Apple";
    Consumer<Integer> hello;

    A() {
        hello = (Integer it) -> System.out.println(it + ": Hello " + this.name);
    }
}

class B {
    // 无法使用 private Consumer hello = A.hello ;  因为A中没有一个static方法叫Hello
    public String name = "Banana";
    Consumer<Integer> hello;
}

public class ThisSample {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();
        obj2.hello = obj1.hello;
        obj2.hello.accept(20); //=> 20: Hello Apple
    }
}