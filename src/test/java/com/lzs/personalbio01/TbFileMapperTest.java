package com.lzs.personalbio01;

import com.lzs.dao.TbFileMapper;
import com.lzs.entity.TbFile;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class TbFileMapperTest {
@Autowired(required = false)
private TbFileMapper tbFileMapper;
    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
        TbFile tbFile = tbFileMapper.selectByPrimaryKey(1);
        System.out.println(tbFile);
    }
    @Test
    public void selectListByMasterId(){
        List<TbFile> tbFiles =
                tbFileMapper.selectListByMasterId("1");
        System.out.println(tbFiles);

    }
}