package com.lzs.service;

import com.lzs.entity.User;


public interface UserService {
    User findByname(String name);
    User findById(Integer id);
    int saveUser(String username,String passwrod);

}
