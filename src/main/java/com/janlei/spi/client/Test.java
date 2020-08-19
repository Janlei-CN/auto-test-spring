package com.janlei.spi.client;

import com.janlei.spi.ISpiStu;
import lombok.extern.slf4j.Slf4j;

import java.util.ServiceLoader;

@Slf4j(topic = "c.Test")
public class Test {

    public static void main(String[] args) {
        ServiceLoader<ISpiStu> load = ServiceLoader.load(ISpiStu.class);
        for (ISpiStu impl : load) {
            impl.parse();
        }

        log.info("test");

        log.info("test github commit push");
    }
}
