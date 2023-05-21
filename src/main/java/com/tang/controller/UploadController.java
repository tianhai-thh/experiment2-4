/*
package com.tang.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {
    @ResponseBody
    @RequestMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        //上传路径
        String path = request.getServletPath().getRealPath("/upload");
        //获得后缀
        String originalFilename = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        //新名称
        String newName = UUID.randomUUID().toString().replaceAll("-", "") + "." + extension;
        File fe = new File(path);
        if (!fe.exists()) {
            fe.mkdir();
        }
        //保存文件
        try {
            file.transferTo(new File(fe + "/" + newName));
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
*/
