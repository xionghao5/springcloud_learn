package com.gua.client;

import org.springframework.stereotype.Service;

@Service
public class FeginClientHystrix implements FeginClient {

    @Override
    public String getHomeFromProvider() {
        return "sorry,error";
    }
}
