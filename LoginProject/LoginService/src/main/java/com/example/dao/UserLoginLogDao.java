package com.example.dao;


import com.example.entity.UserLoginLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserLoginLogDao extends CrudRepository<UserLoginLog,Integer> {

}
