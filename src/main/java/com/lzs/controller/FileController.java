package com.lzs.controller;

import com.lzs.entity.TbFile;
import com.lzs.service.TbFileService;
import com.lzs.util.SysResult;
import com.lzs.vo.TbFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@CrossOrigin
@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired(required = false)
    private TbFileService tbFileService;

    @RequestMapping("/insert")
    public void Addbio(@PathParam("TbFileVO") TbFileVO tbFileVO){
        tbFileService.insert(tbFileVO);
    }


    @RequestMapping("/findById")
    @ResponseBody
    public SysResult findById(@PathParam("id")String id, Model model){
        TbFileVO tbFileVO = new TbFileVO();
        TbFile file = tbFileService.findpath(id);
        tbFileVO.setFilePath(file.getFileAbsPath());
        tbFileVO.setId(file.getId());
        System.out.println(tbFileVO);
        return SysResult.success(tbFileVO);

    }
    //查询图片分组
    @RequestMapping("/findPictures")
    @ResponseBody
    public SysResult findByPictureList(@PathParam("masterId")String masterId){
        String id = "1";//用户id
        String fileType ="img";
        List<TbFileVO> pictures = tbFileService.findPicture(id,masterId,fileType);
        System.out.println("显示层"+pictures);
        return SysResult.success(pictures);
    }
    /*
    单张上传
     */
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    @ResponseBody
    public String FileUpload(MultipartFile file,Integer bid, TbFileVO tbFileVO) throws IOException {
        /**
         * 上传图片
         */String newFileName = null;
        System.out.println("传图"+file);
        try {
            //图片上传成功后，将图片的地址写到数据库
            //创建在服务器端的文件上传的路径
            // String filePath =request.getServletContext().getRealPath("/upload");
            String filePath ="C://file";//保存图片的路径,tomcat中有配置
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//            String add = sdf.format(new Date());
            File fileDir = new File(filePath+"/upload");
            if(!fileDir.exists()) {
                fileDir.mkdirs();
            }

            //获取原始图片的拓展名
            String originalFilename = file.getOriginalFilename();
            //新的文件名字，使用uuid随机生成数+原始图片名字，这样不会重复
            newFileName = UUID.randomUUID()+originalFilename;
            //封装上传文件位置的全路径，就是硬盘路径+文件名
            File targetFile = new File(fileDir,newFileName);
            //把本地文件上传到已经封装好的文件位置的全路径就是上面的targetFile
            file.transferTo(targetFile);
            System.out.println(targetFile);
            tbFileVO.setFilePath(newFileName);//文件名保存到实体类对应属性上);
            String fileType="";
            //保存图片名
            tbFileService.manageFiles(newFileName,bid,fileType);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "失败";
        }
        return "成功"; //重定向到查询
    }


/*
批量图片上传
 */

    @RequestMapping("/MultiPictareaddData")
    @ResponseBody
    public Map<String, Object> MultiPictareaddData(MultipartFile[] file, @RequestParam("bid") Integer bid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("图片类型"+bid);
        List<String> list = new ArrayList<String>();
        Map<String,Object> map=new HashMap<String,Object>();
        if (file != null && file.length > 0) {
            System.out.println(file.length+"王阳明");
            for (int i = 0; i < file.length; i++) {
                MultipartFile filex = file[i];
                // 保存文件
                saveFile(request, filex,bid);
            }
            map.put("success","ok");
            // map.put("msg","上传成功");

        }else{
            System.out.println(file.length+"：长度就是零");
            // map.put("msg","上传失败");

        }
        return map;


    }
    private void saveFile(HttpServletRequest request,MultipartFile file,Integer bid) throws IOException {
        //获取扩展名
        String originalFilename = file.getOriginalFilename();
        String name = file.getName();
        //判断是否是视频
        String reg = "(mp4|flv|avi|rm|rmvb|wmv|3gp|mpg|mov|mkv)";
        Pattern p = Pattern.compile(reg);
        boolean boo = p.matcher(originalFilename).find();
        String fileType =null;
        if(boo){
            fileType="video";
        }else fileType="img";
        System.out.println("文件是视频"+boo);
        //重新配不重复的名
        String randomUUID = UUID.randomUUID().toString();
        int index = originalFilename.lastIndexOf(".");
        String exet = originalFilename.substring(index);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd/HH/mm/ss");
        String dateStr = sdf.format(date); // D://uploads//20180824 String
        String filePath = "C://upload/multilFiles" +"/"+dateStr;
        System.out.println("filePath=" + filePath);
        File file2 = new File(filePath);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String picName = dateStr+"/"+randomUUID + exet;
        filePath += "/" +randomUUID + exet;
        tbFileService.manageFiles(picName,bid, fileType);
        System.out.println(filePath+"P");
        file.transferTo(new File(filePath));// ctrl+1
    }

    @RequestMapping("/findvideos")
    @ResponseBody
    public SysResult findvideos(@PathParam("masterId")String masterId){
        String fileType="video";
        List<TbFile> findvideos = tbFileService.findvideos(masterId, fileType);
        ArrayList<TbFileVO> tbFileVOS = new ArrayList<>();
        for(TbFile video:findvideos){
            TbFileVO tbFileVOPath = new TbFileVO();
            tbFileVOPath.setFilePath(video.getFileAbsPath());
            tbFileVOS.add(tbFileVOPath);
        }
        return SysResult.success(tbFileVOS);
    }
}
