package com.janlei.service.impl;

import com.janlei.service.IHelloService;
import org.springframework.stereotype.Service;

@Service("IHelloService")
public class HelloServiceImpl implements IHelloService{
    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }
}
