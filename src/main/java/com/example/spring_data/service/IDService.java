package com.example.spring_data.service;

import java.util.UUID;


public class IDService {
    public String createID() {
        return UUID.randomUUID().toString();
    }

}
