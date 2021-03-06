package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.PositionDDTO;
import com.demo.hotel.business.dto.PositionDTO;
import com.demo.hotel.business.dto.param.PositionParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.PositionDService;
import com.demo.hotel.provider.api.PositionService;
import com.demo.hotel.provider.domain.Position;
import com.demo.hotel.provider.domain.PositionD;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 职位控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "organization/position")
@RestController
public class PositionController {

    @Reference(version = "1.0.0")
    PositionService positionService;

    @Reference(version = "1.0.0")
    PositionDService positionDService;

    BaseTableController<PositionService,PositionDService,PositionDTO,PositionDDTO,Position,PositionD,PositionParam> bt=new BaseTableController<>();

    /**
     * 获取职位信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<PositionDDTO>> info() {
        return bt.info(positionDService, new PositionDDTO());
    }

    /**
     * 添加职位信息
     *
     * @param positionParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody PositionParam positionParam) {
        Position position = new Position();
        return bt.add(positionService, position, positionParam);
    }

    /**
     * 更新职位信息
     *
     * @param positionDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody PositionDTO positionDTO) {
        Position position = new Position();
        return bt.update(positionService, position, positionDTO);
    }

    /**
     * 删除
     *
     * @param positionDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody PositionDTO positionDTO) {
        Long id = positionDTO.getId();
        return bt.delete(positionService, id);
    }
}
