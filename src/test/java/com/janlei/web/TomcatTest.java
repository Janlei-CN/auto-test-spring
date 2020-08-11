package com.janlei.web;

import org.apache.catalina.startup.Tomcat;

public class TomcatTest {
    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(80);
    }
}
