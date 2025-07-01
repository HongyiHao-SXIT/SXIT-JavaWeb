package com.itheima.tlias.controller;

import com.itheima.tlias.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    private static final String UPLOAD_DIR = "D:/images/";
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString().replace("-", "") + extName;
            File targetFile = new File(UPLOAD_DIR + uniqueFileName);
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            file.transferTo(targetFile);
            String imageUrl = "/images/" + uniqueFileName;
            return Result.success(imageUrl);
        }
        return Result.error("文件为空，上传失败！");
    }
}
