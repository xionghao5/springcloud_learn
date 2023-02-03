package com.gua.consume;


import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    public void consume(String msg){
        System.out.println(msg);
    }
}
