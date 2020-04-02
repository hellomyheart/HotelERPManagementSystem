package com.demo.hotel.provider.mapper;

import com.demo.hotel.provider.domain.OauthPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

/**
 * @author syj
 */
public interface OauthPermissionMapper extends MyMapper<OauthPermission> {

    //传入参数

    List<OauthPermission> selectByUserId(@Param("id") Long id);
}