package com.gua;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GkyHomeController {

    @Value("${server.port}")
    private String value;


    @GetMapping("/home")
    public String home(){
        return "server.port:"+value;
    }
}
