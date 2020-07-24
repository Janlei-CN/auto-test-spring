package com.janlei.mock.ctrl;

import com.janlei.ctrl.BloomFilterCtrl;
import com.janlei.filter.RedisBloomFilter;
import com.janlei.helper.BloomFilterHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class RedisBloomFilterMockTest {

    @MockBean
    BloomFilterCtrl bloomFilterCtrl;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_not_null() {
        Assertions.assertThat(bloomFilterCtrl).isNotNull();
    }

    @Test
    public void test_add() throws Exception {
        RequestBuilder request;
        request = MockMvcRequestBuilders.get("/add")
                .param("orderNum","1");
        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}