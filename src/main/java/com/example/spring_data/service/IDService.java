package com.example.spring_data.service;

import java.util.UUID;

import org.springframework.stereotype.Service;


@Service
public class IDService {
    public String createID() {
        return UUID.randomUUID().toString();
    }

}
