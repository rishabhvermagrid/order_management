package com.hamza.order_management.IOC;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final Foo foo;

    public TestService(Foo foo) {
        this.foo = foo;
    }

    public void test() {
        foo.display();
    }
}