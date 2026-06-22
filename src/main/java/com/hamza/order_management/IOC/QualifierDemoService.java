package com.hamza.order_management.IOC;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QualifierDemoService {

    private final Foo foo;

    public QualifierDemoService(
            @Qualifier("fooImpl1") Foo foo) {

        this.foo = foo;
    }
}