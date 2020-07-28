package com.janlei.ctrl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderCtrlTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url = "http://127.0.0.1:";

    @Value("${server.servlet.context-path}")
    private String name;

    @BeforeEach
    void init() {
        url = url + port + name;
    }

    @Test
    void detail() {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CountDownLatch downLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                String requestResult = restTemplate.getForObject(url + "/detail",
                        String.class);
                Assertions.assertThat(requestResult).contains("order_detail");
            });
            downLatch.countDown();
        }

    }

}