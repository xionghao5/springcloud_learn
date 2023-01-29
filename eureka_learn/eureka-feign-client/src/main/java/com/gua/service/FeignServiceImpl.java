package com.gua.service;


import com.gua.client.FeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignServiceImpl implements FeignService{

    @Autowired
    private FeginClient feginClient;

    @Override
    public String getHome() {
        return feginClient.getHomeFromProvider();
    }
}
