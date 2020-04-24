package com.demo.hotel.business.base.controller;

import com.demo.hotel.business.dto.TableDTO;
import com.demo.hotel.business.dto.param.BaseParam;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.BaseSingleTableApi;
import com.demo.hotel.provider.doamin.TableDomain;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <S> Services
 * @param <D> DTO
 * @param <M> Domain
 * @param <P> Param
 * @program: HotelERPManagementSystem
 * @description: 基础的单表控制器
 * @author: syj
 * @create: 2020-04-24 12:30
 **/
public class BaseSingleTableController<S extends BaseSingleTableApi, D extends TableDTO, M extends TableDomain, P extends BaseParam> extends BaseController<S, D, M, P> {
    //S Services
    //D DTO
    //M Domain
    //P param


    /**
     * 查询所有
     *
     * @param s
     * @param temp
     * @return
     */
    public ResponseResult<List<D>> info(S s, D temp) {
        List<M> domain = s.selectAll();

        List<D> dTO = new ArrayList<>();
        //使用反射创建对象
        Class<?> c = temp.getClass();
        domain.forEach(v -> {
            D d = null;
            try {
                d = (D) c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(v, d);
            dTO.add(d);
        });

        return new ResponseResult<>(CodeStatus.OK, "获取信息成功", dTO);
    }
}
