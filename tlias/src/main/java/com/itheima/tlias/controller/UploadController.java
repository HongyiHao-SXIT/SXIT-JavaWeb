package com.itheima.tlias.controller;

import com.itheima.tlias.bean.Result;
import com.itheima.tlias.utils.MinioUtil;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
      @Autowired
      private MinioUtil minioUtil;
    @PostMapping("/upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String url = minioUtil.upload(file, file.getOriginalFilename());
            return Result.success(url);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("上传失败");
        }

    }

}
