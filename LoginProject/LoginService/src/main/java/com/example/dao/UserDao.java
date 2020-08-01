package com.example.dao;

import com.example.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<Users,Integer> {

    List<Users> findByName(String name);

}
