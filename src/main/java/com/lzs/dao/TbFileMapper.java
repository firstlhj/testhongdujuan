package com.lzs.dao;

import com.lzs.entity.TbFile;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface TbFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbFile record);

    int insertSelective(TbFile record);

    TbFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbFile record);

    int updateByPrimaryKey(TbFile record);

    List<TbFile> selectListByMasterId(String id);
    List<TbFile> selectListByMasterIdAndRestype(@Param("id") String id,@Param("Restype")String Restype);

}