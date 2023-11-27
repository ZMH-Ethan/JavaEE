package com.example.demo.ReadYml;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Component

public class readyml {
    @Value("${server.port}")
    private String port;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Read YML,port:" + port);
    }
}