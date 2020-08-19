package com.janlei.client;

import com.janlei.spi.ISpiStu;

import java.util.ServiceLoader;

public class Test {

    public static void main(String[] args) {
        ServiceLoader<ISpiStu> load = ServiceLoader.load(ISpiStu.class);
        for (ISpiStu impl : load) {
            impl.parse();
        }
    }
}
