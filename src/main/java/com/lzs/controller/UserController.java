package com.lzs.controller;

import com.lzs.enums.ServiceErrCode;
import com.lzs.exception.BaseServiceException;
import com.lzs.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("/login")
    public String  toLogin(){
        return "/login2";
    }
    @RequestMapping("/failed")
    public String  toerror(){
        return "/errors";
    }
    @RequestMapping("/demo")
    public String  demo(){
        return "demo";
    }
    @RequestMapping("/swaplogin")
    public String  swaplogin(){
        return "swaplogin";
    }
    //登录接收参数
    @RequestMapping("/login3")
    public String login(String username, String password, Model model){
      System.out.println(username);
        if(username==null||password==null){
            throw new BaseServiceException("用户信息输入不能为空", ServiceErrCode.REQ_PARAM_ERR);
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 开启记住我的功能，这里可以通过获取用户的提交的信息，判断是否选择记住我来决定开启或关闭
//        try{
//            if(rememberMe){
//                token.setRememberMe(true);
//            }
//        }catch (NullPointerException e){
//            token.setRememberMe(false);
//        }

        try {
//            token.setRememberMe(rememberMe);
            subject.login(token);
            return "redirect:/homepage";
        } catch (Exception e) {
            //e.printStackTrace();
            model.addAttribute("msg","用户名不存在");
            return "swaplogin";

        }
    }

    @RequestMapping("/register")
    public String register(String username,String password,String email){
        //判断信息是否填写
        if(username==null||password==null||email==null){
          return null;
        }
        //插入数据库
        int r = userService.saveUser(username, password);
        System.out.println("注册"+r);
        return "swaplogin";
    }
}
