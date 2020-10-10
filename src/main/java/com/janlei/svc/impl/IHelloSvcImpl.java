package com.janlei.svc.impl;

import com.janlei.svc.IHelloSvc;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service("IHelloSvc")
public class IHelloSvcImpl implements IHelloSvc{
    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }
}
