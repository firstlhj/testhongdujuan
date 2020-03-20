package com.lzs.service;//
//

//
//  @ Project : Untitledersonalbio
//  @ File Name : TbFileService.java
//  @ Date : 2020/3/11
//  @ Author : @lhj
//
//


import com.lzs.entity.TbFile;
import com.lzs.vo.TbFileVO;

import java.util.List;

public interface TbFileService {
	public void insert(TbFileVO tbFileVo);
	public TbFile findpath(String id);
	public List<TbFileVO> findPicture(String id,String Restype,String fileType);
	public int manageFiles(String newFileName,Integer Restype,String fileType);
	public List<TbFile> findvideos(String id ,String fileType);
}
