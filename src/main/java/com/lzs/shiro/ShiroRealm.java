package com.lzs.shiro;

import com.lzs.entity.User;
import com.lzs.enums.ServiceErrCode;
import com.lzs.exception.BaseServiceException;
import com.lzs.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        User user1 = userService.findById(user.getId());
        info.addStringPermission(user1.getPermission());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        User principal = (User) token.getPrincipal();
//        String name = principal.getName();
        System.out.println("执行认证逻辑");
        //编写shiro判断逻辑，判断用户名和密码
        UsernamePasswordToken token1  =  (UsernamePasswordToken)token;
        String username = token1.getUsername();
        System.out.println(username);
        User user = userService.findByname(username);
        if(user==null){
            System.out.println("用户不存在");
            return null;

        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), user.getUsername());


    }
}
