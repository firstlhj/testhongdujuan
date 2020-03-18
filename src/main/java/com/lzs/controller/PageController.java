package com.lzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@CrossOrigin
public class PageController {
    @RequestMapping("/ajax")
    public String ajax(){
        return "pages/ajax";
    }
    @RequestMapping("/index")
    public String index()
    {
        return "pages/tbfile";
    }
    //批量上传
    @RequestMapping("/fileupload")
    public String upload()
    {
        //return "upload/index";
        return "/upload/uploadfiles";
    }
    @RequestMapping("/show")
    public String move()
    {
        return "/move/tuozhuai";
    }
    @RequestMapping("/jianli")
    public String resouces()
    {
        return "/myresources/jianli2";
    }
    //restful接口风格
    @RequestMapping("/{homepage}")
    public String home(@PathVariable String homepage)
    {
        return "/myresources/"+homepage;
    }
   @RequestMapping("/uploadfiles")
    public String uploadfiles(){
        return "/upload/multiuploads";
   }

}
