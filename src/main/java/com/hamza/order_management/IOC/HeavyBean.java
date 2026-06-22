package com.hamza.order_management.IOC;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HeavyBean {

    public HeavyBean() {
        System.out.println("Heavy Bean Loaded");
    }
}