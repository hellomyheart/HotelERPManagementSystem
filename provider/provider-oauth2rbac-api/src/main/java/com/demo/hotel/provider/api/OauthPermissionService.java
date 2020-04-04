package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.OauthPermission;

import java.util.List;

/**
 * @author syj
 */
public interface OauthPermissionService {

    List<OauthPermission> selectByUserId(Long id);
}
