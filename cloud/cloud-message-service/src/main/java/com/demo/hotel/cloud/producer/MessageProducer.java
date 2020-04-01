package com.demo.hotel.cloud.producer;

import com.demo.hotel.cloud.api.MessageService;
import com.demo.hotel.cloud.dto.AdminLoginLogDTO;
import com.demo.hotel.cloud.message.MessageSource;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消息生产者
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-10-20 17:33:21
 * @see com.demo.hotel.cloud.producer
 */
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
