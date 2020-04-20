package com.demo.hotel.message.consumer;

import com.demo.hotel.provider.api.SendSmsService;
import com.demo.hotel.provider.domain.UserCode;
import com.demo.hotel.commons.utils.MapperUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @author syj
 */
@Service
public class UserCodeReceive {

    @Reference(version = "1.0.0")
    private SendSmsService sendSmsService;

    @StreamListener("user-code-topic")
    public void receiveUserCode(String userCodeJson) throws Exception {
        UserCode userCode = MapperUtils.json2pojo(userCodeJson, UserCode.class);
       sendSmsService.sendCode(userCode.getPhoneNumber(),userCode.getCode());
    }

}
