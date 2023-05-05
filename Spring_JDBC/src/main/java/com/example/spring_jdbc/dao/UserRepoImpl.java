package com.example.spring_jdbc.dao;

import com.example.spring_jdbc.entity.User;

import java.util.List;

public interface UserRepoImpl {
    User saveuser(User user);
    int deletebyid(int id);
    User getbyid(int id);
    User updateuser(User user);
    List<User> allusers();

}
