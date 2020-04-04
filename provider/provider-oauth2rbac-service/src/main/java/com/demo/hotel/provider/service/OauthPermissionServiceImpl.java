package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.OauthPermission;
import com.demo.hotel.provider.mapper.OauthPermissionMapper;
import com.demo.hotel.provider.api.OauthPermissionService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class OauthPermissionServiceImpl implements OauthPermissionService{

    @Resource
    private OauthPermissionMapper oauthPermissionMapper;

    @Override
    public List<OauthPermission> selectByUserId(Long id) {
        return oauthPermissionMapper.selectByUserId(id);
    }
}
