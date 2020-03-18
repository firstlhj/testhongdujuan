package com.lzs.serviceImpl;//
//

//
//  @ Project : Untitledersonalbio
//  @ File Name : TbFileServiceImpl.java
//  @ Date : 2020/3/11
//  @ Author : @lhj
//
//


import com.lzs.dao.TbFileMapper;
import com.lzs.entity.TbFile;
import com.lzs.service.TbFileService;
import com.lzs.vo.TbFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbFileServiceImpl implements TbFileService {
	@Autowired(required = false)
	private TbFileMapper tbFileMapper;
	public void insert(TbFileVO tbFileVo) {
		String useId="2";
		TbFile tbFile = new TbFile();
		tbFile.setId(Integer.valueOf(tbFileVo.getId()));
		tbFile.setFileAbsPath(tbFileVo.getFilePath());
		tbFile.setMasterId(useId);

		tbFileMapper.insert(tbFile);
	}

	public TbFile findpath(String id){
		TbFile tbFile = tbFileMapper.selectByPrimaryKey(Integer.valueOf(id));
		return tbFile;

	};

	public List<TbFileVO> findPicture(String id ,String Restype){
		List<TbFile> tbFiles =
				tbFileMapper.selectListByMasterIdAndRestype(id,Restype);
		System.out.println(tbFiles);
		List<TbFileVO> tbFileVOS = new ArrayList<>();
		for(TbFile t : tbFiles){
			TbFileVO tbFileVO = new TbFileVO();
			String fileAbsPath = t.getFileAbsPath();
			tbFileVO.setFilePath(fileAbsPath);
			tbFileVOS.add(tbFileVO);
		}
		return tbFileVOS;
	}
/*
  文件路径保存数据库
 */
	@Override
	public int manageFiles(String newFileName,Integer Restype) {
		TbFile tbFile = new TbFile();
		//域名或ip拼接虚拟路径，即可外网访问
		String path="http://47.112.148.238/upload/"+newFileName;
		//文件内容存在服务器文件夹
		System.out.println(path);

		tbFile.setId(null);
		tbFile.setFileAbsPath(path);
		tbFile.setMasterId("1");//即用户id
		tbFile.setResourcetype(String.valueOf(Restype));
		//根据文件路径生成连接url
		int in = tbFileMapper.insert(tbFile);
		//保存url到数据库
		return in;

	}
}
