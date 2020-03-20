package com.lzs.dao;

import com.lzs.entity.TbFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TbFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbFile record);

    int insertSelective(TbFile record);

    TbFile selectByPrimaryKey( Integer id);

    int updateByPrimaryKeySelective(TbFile record);

    int updateByPrimaryKey(TbFile record);

    List<TbFile> selectListByMasterId(String id);

    List<TbFile> selectListByMasterIdAndRestype(@Param("id") String id,
                                                @Param("Restype")String Restype,
                                                @Param("fileType")String fileType);

    List<TbFile>selectVideos(@Param("id") String id,
                             @Param("fileType")String fileType);

}