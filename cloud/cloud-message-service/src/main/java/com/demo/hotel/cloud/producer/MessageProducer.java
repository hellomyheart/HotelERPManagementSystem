package com.demo.hotel.cloud.producer;

import com.demo.hotel.cloud.api.MessageService;
import com.demo.hotel.cloud.dto.AdminLoginLogDTO;
import com.demo.hotel.cloud.dto.UserCodeDTO;
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

    /**
     * 发送用户验证码服务
     * @param userCodeDTO
     * @return
     */
    @Override
    public boolean sendUserCode(UserCodeDTO userCodeDTO) {
        return source.userCode().send(MessageBuilder.withPayload(userCodeDTO).build());
    }
}
