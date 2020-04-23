package com.demo.hotel.business.base.controller;

import org.springframework.beans.BeanUtils;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.BaseTableApi;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 基础控制器
 * @author: syj
 * @create: 2020-04-23 10:58
 **/
public class BaseController<S extends BaseTableApi, D, M, P> {

    //S Services
    //D DTO
    //M Domain
    //P param

    /**
     * 添加
     *
     * @param s Services
     * @param m Domain
     * @param p param
     * @return
     */
    public ResponseResult<Void> add(S s, M m, P p) {

        BeanUtils.copyProperties(p, m);
        int result = s.insert(m);
        if (result > 0) {
            //添加成功
            return new ResponseResult<>(CodeStatus.OK, "添加成功");
        }
        //添加失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "添加失败");
        }
    }


    /**
     * 添加
     *
     * @param s Services
     * @param m Domain
     * @return
     */
    public ResponseResult<Void> add(S s, M m) {

        int result = s.insert(m);
        if (result > 0) {
            //添加成功
            return new ResponseResult<>(CodeStatus.OK, "添加成功");
        }
        //添加失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "添加失败");
        }
    }


    /**
     * 更新
     *
     * @param s Services
     * @param m Domain
     * @param d DTO
     * @return
     */
    public ResponseResult<Void> update(S s, M m, D d) {
        BeanUtils.copyProperties(d, m);
        int result = s.update(m);
        if (result > 0) {
            //更新成功
            return new ResponseResult<>(CodeStatus.OK, "更新成功");
        }
        //更新失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "更新失败");
        }
    }

    /**
     * 更新
     *
     * @param s Services
     * @param m Domain
     * @return
     */
    public ResponseResult<Void> update(S s, M m) {
        int result = s.update(m);
        if (result > 0) {
            //更新成功
            return new ResponseResult<>(CodeStatus.OK, "更新成功");
        }
        //更新失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "更新失败");
        }
    }


    /**
     * 删除
     *
     * @param s  Services
     * @param id id
     * @return
     */
    public ResponseResult<Void> delete(S s, Long id) {
        int result = s.delete(id);
        if (result > 0) {
            //删除成功
            return new ResponseResult<>(CodeStatus.OK, "删除成功");
        }
        //删除失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "删除失败");
        }
    }
}
