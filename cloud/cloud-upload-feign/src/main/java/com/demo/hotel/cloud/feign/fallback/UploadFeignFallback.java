package com.demo.hotel.cloud.feign.fallback;

import com.demo.hotel.cloud.feign.UploadFeign;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.commons.utils.MapperUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: HotelERPManagementSystem
 * @description: upload服务熔断器
 * @author: syj
 * @create: 2020-03-31 18:59
 **/
@Component
public class UploadFeignFallback implements UploadFeign {
    private static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";

    @Override
    public String upload(MultipartFile multipartFile) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
