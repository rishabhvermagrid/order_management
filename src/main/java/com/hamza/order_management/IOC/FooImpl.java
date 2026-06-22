package com.hamza.order_management.IOC;

import org.springframework.stereotype.Component;

@Component
public class FooImpl implements Foo {

    @Override
    public void display() {
        System.out.println("Hello from FooImpl");
    }
}