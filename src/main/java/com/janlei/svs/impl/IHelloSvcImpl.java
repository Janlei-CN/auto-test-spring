package com.janlei.svs.impl;

import com.janlei.svs.IHelloSvc;
import org.springframework.stereotype.Service;

@Service("IHelloSvc")
public class IHelloSvcImpl implements IHelloSvc{
    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }
}
