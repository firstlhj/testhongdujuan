package com.lzs.serviceImpl;

import com.lzs.dao.UserMapper;
import com.lzs.entity.User;
import com.lzs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
  @Autowired(required = false)
  private UserMapper userMapper;
  @Autowired
  private RedisTemplate redisTemplate;
    @Override
    public User findByname(String name) {
        String key = "user_" + name;
        ValueOperations<String,User> Operations = redisTemplate.opsForValue();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            User user = Operations.get(key);
            System.out.println("从缓存中获得数据："+user.getUsername());
            System.out.println("------------------------------------");
            return user;
        }else{
            User user = userMapper.findByName(name);
            System.out.println("查询数据库获得数据："+user.getUsername());
            System.out.println("------------------------------------");
            Operations.set(key,user,5, TimeUnit.HOURS);
            return user;
        }



    }

    @Override
    public User findById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int saveUser(String username, String passwrod) {
        User user = new User();
        user.setId(null);
        user.setUsername(username);
        user.setPassword(passwrod);
        user.setPermission("user:update");
        int in = userMapper.insert(user);
        if(in!=0){
            System.out.println("注册成功");
        }
        return in;
    }
}
