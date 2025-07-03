package com.itheima.tlias.utils;

import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.messages.Item;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component
public class MinioUtil {

    private static String endpoint = "https://objectstorageapi.bja.sealos.run";
    private static String accessKey = "4otkc4qi";
    private static String secretKey = "2vxvddgp4sbv92qk";
    private static String bucketName = "4otkc4qi-my-minio";

    private static MinioClient minioClient;

    @PostConstruct
    public void init() {
        minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    public static String upload(MultipartFile file, String objectName) throws IOException {
        try {
            File tempFile = convert(file);
            if (tempFile == null) throw new IOException("转换失败");

            if (objectName == null || objectName.isEmpty()) {
                objectName = UUID.randomUUID() + "-" + file.getOriginalFilename();
            }

            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .filename(tempFile.getAbsolutePath())
                            .build());

            tempFile.delete();

            return endpoint + "/" + bucketName + "/" + objectName;
        } catch (Exception e) {
            throw new IOException("上传失败: " + e.getMessage());
        }
    }

    public static boolean delete(String objectName) throws Exception {
        minioClient.removeObject(
                RemoveObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build());
        return true;
    }

    public static void download(String objectName, String filePath) throws Exception {
        minioClient.downloadObject(
                DownloadObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .filename(filePath)
                        .build());
    }

    public static List<String> listFiles() throws Exception {
        List<String> files = new ArrayList<>();
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket(bucketName).build());

        for (Result<Item> result : results) {
            Item item = result.get();
            files.add(item.objectName());
        }
        return files;
    }

    private static File convert(MultipartFile multipartFile) throws IOException {
        File tempFile = File.createTempFile("upload-", ".tmp");
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
        }
        return tempFile;
    }
}
