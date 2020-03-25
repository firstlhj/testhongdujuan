package com.lzs.personalbio01;

import com.lzs.dao.UserMapper;
import com.lzs.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
@Autowired(required = false)
private UserMapper userMapper;
//    @Test
//    public void deleteByPrimaryKey() {
//    }

    @Test
    public void insert() {
        User user = new User();
        user.setId(3);
        user.setPassword("12345");
        user.setUsername("lzs");
        userMapper.insert(user);

    }

//    @Test
//    public void selectByPrimaryKey() {
//    }
}