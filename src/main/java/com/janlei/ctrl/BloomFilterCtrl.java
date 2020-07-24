package com.janlei.ctrl;

import com.janlei.filter.RedisBloomFilter;
import com.janlei.helper.BloomFilterHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BloomFilterCtrl {

    @Autowired
    RedisBloomFilter redisBloomFilter;

    @Autowired
    private BloomFilterHelper bloomFilterHelper;

    @ResponseBody
    @RequestMapping("/add")
    public boolean addBloomFilter(@RequestParam("orderNum") String orderNum) {
        boolean result = true;
        try {
            redisBloomFilter.addByBloomFilter(bloomFilterHelper, "bloom", orderNum);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/check")
    public boolean checkBloomFilter(@RequestParam("orderNum") String orderNum) {
        boolean isInclude = redisBloomFilter.includeByBloomFilter(bloomFilterHelper, "bloom", orderNum);
        return isInclude;
    }
}
