package com.demo.hotel.cloud.feign.fallback;

import com.demo.hotel.business.feign.fallback.CommonsFeignFallback;
import com.demo.hotel.business.feign.fallback.FeignFallbackMessage;
import com.demo.hotel.cloud.feign.UploadFeign;
import com.demo.hotel.commons.dto.CodeStatus;
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

    @Override
    public String upload(MultipartFile multipartFile) {
        return new CommonsFeignFallback<Void>().Message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }
}
