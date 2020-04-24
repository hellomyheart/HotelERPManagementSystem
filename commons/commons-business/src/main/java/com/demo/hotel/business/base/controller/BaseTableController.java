package com.demo.hotel.business.base.controller;

import com.demo.hotel.business.dto.TableDTO;
import com.demo.hotel.business.dto.ViewDTO;
import com.demo.hotel.business.dto.param.BaseParam;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.BaseTableApi;
import com.demo.hotel.provider.api.BaseViewApi;
import com.demo.hotel.provider.doamin.TableDomain;
import com.demo.hotel.provider.doamin.ViewDomain;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <S>  Service
 * @param <VS> VService
 * @param <D>  DTO
 * @param <VD> VDTO
 * @param <M>  Domain
 * @param <VM> VDomain
 * @param <P>  param
 * @program: HotelERPManagementSystem
 * @description: 基础的多表控制器
 * @author: syj
 * @create: 2020-04-24 12:33
 */
public class BaseTableController<S extends BaseTableApi, VS extends BaseViewApi, D extends TableDTO, VD extends ViewDTO, M extends TableDomain, VM extends ViewDomain, P extends BaseParam> extends BaseController<S, D, M, P> {


    /**
     * 查询所有
     *
     * @param vs   VService
     * @param temp VDTO
     * @return
     */
    public ResponseResult<List<VD>> info(VS vs, VD temp) {
        List<VM> vDomain = vs.selectAll();

        List<VD> vDTO = new ArrayList<>();
        //使用反射创建对象
        Class<?> c = temp.getClass();
        vDomain.forEach(v -> {
            VD d = null;
            try {
                d = (VD) c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(v, d);
            vDTO.add(d);
        });

        return new ResponseResult<>(CodeStatus.OK, "获取信息成功", vDTO);
    }
}
