package com.example.service;

import com.example.entity.Users;

import java.util.Map;


public interface UserService {

    void save(Users user);

    Map<String, String> login(Users users);

}
