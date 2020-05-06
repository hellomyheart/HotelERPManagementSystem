package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.RoomOrderDTO;
import com.demo.hotel.business.dto.param.RoomOrderParam;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.RoomOrderService;
import com.demo.hotel.provider.api.RoomService;
import com.demo.hotel.provider.api.RoomTypeService;
import com.demo.hotel.provider.domain.Room;
import com.demo.hotel.provider.domain.RoomOrder;
import com.demo.hotel.provider.domain.RoomType;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @Reference(version = "1.0.0")
    RoomService roomService;

    @Reference(version = "1.0.0")
    RoomTypeService roomTypeService;

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

        //1.更新房间状态
        Room room = roomService.getById(param.getRoomId());
        room.setStatus(1);
        roomService.update(room);

        //2.减少对应房间类型数量
        RoomType roomType = roomTypeService.getById(room.getTypeId());
        roomType.setRoomCount(roomType.getRoomCount() - 1);
        roomTypeService.update(roomType);

        //已付
        param.setDepositStatus(1);
        param.setOrderStatus(1);
        param.setCreatTime(new Date());
        param.setCheckIn(new Date());


        RoomOrder roomOrder = new RoomOrder();

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

        if (dTO.getDepositStatus() == 2) {
            //1.更新房间状态
            Room room = roomService.getById(dTO.getRoomId());
            room.setStatus(2);
            roomService.update(room);

            //2.添加对应房间类型数量
            RoomType roomType = roomTypeService.getById(room.getTypeId());
            roomType.setRoomCount(roomType.getRoomCount() + 1);
            roomTypeService.update(roomType);
            RoomOrder roomOrder = new RoomOrder();
            return bs.update(service, roomOrder, dTO);
        }
        return new ResponseResult<>(CodeStatus.FAIL, "失败");

    }
}
