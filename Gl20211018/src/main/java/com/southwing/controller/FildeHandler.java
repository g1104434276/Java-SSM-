package com.southwing.controller;

import org.apache.commons.fileupload.util.LimitedInputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FildeHandler {

    @PostMapping("/upload")
    public String upload(MultipartFile img, HttpServletRequest request) {
        if (img.getSize() > 0) {
            //获取保存上传文件的file路径
            String path = request.getServletContext().getRealPath("file");
            System.out.println(path);
            //获取一个文件名
            String name = img.getOriginalFilename();
            File file = new File(path, name);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                img.transferTo(file);
                //保存上传之后的翁建路径
                request.setAttribute("path", "/file/" + name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] imgs, HttpServletRequest request) {
        List<String> files = new ArrayList<>();
        for (MultipartFile img : imgs) {
            if (img.getSize() > 0) {
                //获取保存上传文件的file路径
                String path = request.getServletContext().getRealPath("file");
                System.out.println(path);
                //获取一个文件名
                String name = img.getOriginalFilename();
                File file = new File(path, name);
                if (!file.exists()) {
                    file.mkdirs();
                }
                try {
                    img.transferTo(file);
                    //保存上传之后的创建路径
                    files.add("/file/" + name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("path","/file/"+ files);
        return "uploads";
    }
}