package com.hamza.order_management.IOC;

import org.springframework.stereotype.Component;

@Component
public class FooImpl1 implements Foo {

    @Override
    public void display() {
        System.out.println("FooImpl1");
    }
}