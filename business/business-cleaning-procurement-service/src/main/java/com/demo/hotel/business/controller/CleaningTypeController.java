package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.CleaningTypeDTO;
import com.demo.hotel.business.dto.param.CleaningTypeParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.CleaningTypeService;
import com.demo.hotel.provider.domain.CleaningType;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "cleaningProcurement/type")
@RestController
public class CleaningTypeController {

    @Reference(version = "1.0.0")
    CleaningTypeService service;

    BaseSingleTableController<CleaningTypeService, CleaningTypeDTO, CleaningType, CleaningTypeParam> bs=new BaseSingleTableController<>();
    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<CleaningTypeDTO>> info() {
        return bs.info(service, new CleaningTypeDTO());
    }

    /**
     * 添加
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody CleaningTypeParam param){
        return bs.add(service, new CleaningType(), param);
    }

    /**
     * 更新
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody CleaningTypeDTO dTO){
        return bs.update(service, new CleaningType(), dTO);
    }

    /**
     * 删除
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody CleaningTypeDTO dTO){
        Long id = dTO.getId();
        return bs.delete(service, id);
    }
}
