package com.example.service;

import com.example.entity.UserLoginLog;

import java.util.List;


public interface UserLoginLogService {

    void save(UserLoginLog userLoginLog);

    List<UserLoginLog> loginLog();

}
