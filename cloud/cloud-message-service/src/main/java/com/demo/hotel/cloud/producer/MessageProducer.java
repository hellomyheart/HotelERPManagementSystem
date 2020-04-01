package com.demo.hotel.cloud.producer;

import com.demo.hotel.cloud.api.MessageService;
import com.demo.hotel.cloud.dto.AdminLoginLogDTO;
import com.demo.hotel.cloud.message.MessageSource;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: HotelERPManagementSystem
 * @description: 消息生产者
 * @author: syj
 * @create: 2020-03-31 22:33
 **/
@Component
@Service(version = "1.0.0")
public class MessageProducer implements MessageService {

    @Resource
    private MessageSource source;

    /**
     * 管理登录日志
     *
     * @param dto {@link AdminLoginLogDTO}
     * @return {@code boolean}
     */
    @Override
    public boolean sendAdminLoginLog(AdminLoginLogDTO dto) {
        return source.adminLoginLog().send(MessageBuilder.withPayload(dto).build());
    }
}