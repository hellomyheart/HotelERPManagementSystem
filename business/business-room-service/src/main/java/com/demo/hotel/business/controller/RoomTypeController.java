package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.RoomTypeDTO;
import com.demo.hotel.business.dto.param.RoomTypeParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.RoomTypeService;
import com.demo.hotel.provider.domain.RoomType;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 房间类型控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "room/type")
@RestController
public class RoomTypeController {

    @Reference(version = "1.0.0")
    RoomTypeService service;

    BaseSingleTableController<RoomTypeService, RoomTypeDTO, RoomType, RoomTypeParam> bs = new BaseSingleTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<RoomTypeDTO>> info() {
        return bs.info(service, new RoomTypeDTO());
    }

    /**
     * 添加信息
     *
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody RoomTypeParam param) {
        RoomType roomType = new RoomType();
        return bs.add(service, roomType, param);
    }

    /**
     * 更新信息
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody RoomTypeDTO dTO) {
        RoomType roomType = new RoomType();
        return bs.update(service, roomType, dTO);
    }

    /**
     * 删除信息
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody RoomTypeDTO dTO) {
        Long id = dTO.getId();
        return bs.delete(service, id);
    }
}
