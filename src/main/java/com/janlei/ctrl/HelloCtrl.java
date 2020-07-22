package com.janlei.ctrl;

import com.janlei.svc.IHelloSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCtrl {

    @Autowired
    private IHelloSvc helloService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloService.hello(name);
    }
}
