package com.janlei.ctrl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloCtrlTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url = "http://127.0.0.1:";

    @BeforeEach
    void init(){
        url = url + port;
    }

    @Test
    void hello() {
        String requestResult = this.restTemplate.getForObject(url + "/hello/spring",
                String.class);
        Assertions.assertThat(requestResult).contains("Hello, spring");
    }

}