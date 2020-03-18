package com.lzs.personalbio01;

import com.lzs.service.TbFileService;
import com.lzs.vo.TbFileVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TbFileServiceTest {
@Autowired(required = false)
private TbFileService tbFileService;
    @Test
    public void insert() {
        TbFileVO tbFileVO = new TbFileVO();
        tbFileVO.setId(2);
        tbFileVO.setFilePath("http://47.112.148.238/lzs/test.mp4");
        tbFileService.insert(tbFileVO);
    }

    @Test
    public void findpath() {
    }
    @Test void findPicture(){
       System.out.println(tbFileService.findPicture("1","1"));
    }
}