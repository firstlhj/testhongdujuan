package com.lzs.personalbio01;

import com.lzs.entity.User;
import com.lzs.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
@Autowired(required = false)
private UserService userService;
    @Test
  public void findByname() {
        User lzs = userService.findByname("lzs");
        System.out.println(lzs);

    }

    @Test
    public void findById() {
        User byId = userService.findById(1);
        System.out.println(byId);
    }
}