package com.janlei.mock.ctrl;

import com.janlei.ctrl.HelloCtrl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloCtrlMockTest {

    @Autowired
    private HelloCtrl helloCtrl;


    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private HelloCtrl helloCtrlMock;


    @Test
    public void testNotNull() {
        Assertions.assertThat(helloCtrl).isNotNull();
    }

    @Test
    public void testHello() throws Exception {
        RequestBuilder request;
        request = MockMvcRequestBuilders.get("/hello/spring");
        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, spring"));
    }

//    @Test
//    public void test_mock() {
//        when(helloCtrlMock.hello("spring")).thenReturn("Hello, spring");
//        String rep = helloCtrlMock.hello("spring");
//        org.junit.jupiter.api.Assertions.assertEquals("Hello, spring", rep);
//    }
}
