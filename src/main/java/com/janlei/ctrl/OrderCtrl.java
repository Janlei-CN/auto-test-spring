package com.janlei.ctrl;

import com.janlei.annotation.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderCtrl {

    /**
     * 跳转订单详情页面--下单
     */
    @GetMapping("/detail")
    @Token(generate = true)
    public String orderPage(){
 
        //TODO 调用具体业务逻辑-生成订单
 
        log.info("打开订单详情...");
        return "order_detail";
    }
 
    /**
     * 提交订单
     */
    @GetMapping("/submit")
    @Token(remove = true)
    public String orderSubmit(){
 
        //TODO 调用具体业务逻辑--提交订单
 
        log.info("hello,订单提交成功。");
        return "success";
    }
 
}