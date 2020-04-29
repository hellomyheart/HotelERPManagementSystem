package com.demo.hotel.cloud.feign;

import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: HotelERPManagementSystem
 * @description: 文件上传接口
 * @author: syj
 * @create: 2020-03-31 12:31
 **/
@FeignClient(value = "cloud-upload", path = "upload", configuration = FeignRequestConfiguration.class)
public interface UploadFeign {

    /**
     * 文件上传
     *@RequestPart 文件上传需要这个注解
     * @param multipartFile {@code MultipartFile}
     * @return {@code String} 文件上传路径
     */
    @PostMapping(value = "")
    String upload(@RequestPart(value = "multipartFile") MultipartFile multipartFile);
}
