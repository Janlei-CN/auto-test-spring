package com.janlei.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * 测试Junit5是否能正常使用
 */
public class Client {

    @Test
    void test_is_normal(){
        Assertions.assertEquals(5,2+3);
    }

    @Test
    void test_is_exception(){
        Assertions.assertThrows(NumberFormatException.class, ()->Integer.parseInt("dknjh"));
    }
}
