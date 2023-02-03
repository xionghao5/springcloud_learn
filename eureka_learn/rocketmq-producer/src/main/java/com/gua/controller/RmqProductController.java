package com.gua.controller;


import com.gua.product.RmqSyncProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class RmqProductController {

    @Autowired
    private RmqSyncProducer producer;

    @GetMapping("/sendMsg")
    public void sendMsg(String msg) throws Exception {
        producer.setMsg(msg);
    }
}
