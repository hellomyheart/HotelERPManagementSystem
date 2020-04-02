```java
package com.demo.hotel.cloud.controller;

import com.aliyun.oss.OSS;

import com.aliyun.oss.OSSClientBuilder;

import com.aliyun.oss.model.PutObjectRequest;

import com.demo.hotel.cloud.dto.FileInfo;

import com.demo.hotel.commons.dto.ResponseResult;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

import java.io.IOException;

import java.util.UUID;

/**

- @program: HotelERPManagementSystem
- @description: 文件上传控制器
- @author: syj
- @create: 2020-03-31 12:39
  **/
  @RestController
  @RequestMapping(value = "upload")
  public class UploadController {
  //请填入你的oss信息
  private static final String ENDPOINT = "xxx";
  private static final String ACCESS_KEY_ID = "xxx";
  private static final String ACCESS_KEY_SECRET = "xxx";
  private static final String BUCKET_NAME = "xxx";
  /**
  - 文件上传
    *
  - @param multipartFile @{code MultipartFile}
  - @return {@link ResponseResult<FileInfo>} 文件上传路径
    */
    @PostMapping(value = "")
    public ResponseResult<FileInfo> upload(MultipartFile multipartFile) {
    String fileName = multipartFile.getOriginalFilename();
    String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
    String newName = UUID.randomUUID() + "." + suffix;
    OSS client = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    try {
        client.putObject(new PutObjectRequest(BUCKET_NAME, newName, new ByteArrayInputStream(multipartFile.getBytes())));
        // 上传文件路径 = http://BUCKET_NAME.ENDPOINT/自定义路径/fileName
        return new ResponseResult<FileInfo>(CodeStatus.OK, "文件上传成功", new FileInfo("http://" + BUCKET_NAME + "." + ENDPOINT + "/" + newName));
    } catch (IOException e) {
        return new ResponseResult<FileInfo>(CodeStatus.FAIL, "文件上传失败，请重试");
    } finally {
        client.shutdown();
    }
    }

}

```


