package com.janlei.filter;

import com.janlei.helper.BloomFilterHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisBloomFilterTest {

    @Autowired
    RedisBloomFilter redisBloomFilter;

    @Autowired
    private BloomFilterHelper bloomFilterHelper;

    @Test
    public void test_add() {
        boolean result = true;
        String orderNum = "1";
        try {
            redisBloomFilter.addByBloomFilter(bloomFilterHelper, "bloom", orderNum);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        assert result;
    }


    @Test
    public void test_check_BloomFilter() {
        String orderNum = "1";
        boolean b = redisBloomFilter.includeByBloomFilter(bloomFilterHelper, "bloom", orderNum);
        assert b;
    }

}