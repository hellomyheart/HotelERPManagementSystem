package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.RoomOrderDTO;
import com.demo.hotel.business.dto.param.RoomOrderParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.RoomOrderService;
import com.demo.hotel.provider.domain.RoomOrder;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 订单类型控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "room/order")
@RestController
public class RoomOrderController {

    @Reference(version = "1.0.0")
    RoomOrderService service;

    BaseSingleTableController<RoomOrderService, RoomOrderDTO, RoomOrder, RoomOrderParam> bs = new BaseSingleTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<RoomOrderDTO>> info() {
        return bs.info(service, new RoomOrderDTO());
    }

    /**
     * 添加信息
     *
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody RoomOrderParam param) {
        RoomOrder roomOrder=new RoomOrder();
        return bs.add(service, roomOrder, param);
    }

    /**
     * 更新信息
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody RoomOrderDTO dTO) {
        RoomOrder roomOrder=new RoomOrder();
        return bs.update(service, roomOrder, dTO);
    }

    /**
     * 删除信息
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody RoomOrder dTO) {
        Long id = dTO.getId();
        return bs.delete(service, id);
    }
}
