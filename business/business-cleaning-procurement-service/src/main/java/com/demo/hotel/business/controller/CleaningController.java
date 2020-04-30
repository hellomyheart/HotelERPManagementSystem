package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.CleaningDTO;
import com.demo.hotel.business.dto.CleaningTDTO;
import com.demo.hotel.business.dto.param.CleaningParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.CleaningPService;
import com.demo.hotel.provider.api.CleaningTService;
import com.demo.hotel.provider.domain.Cleaning;
import com.demo.hotel.provider.domain.CleaningT;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 职工控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "cleaningProcurement/goods")
@RestController
public class CleaningController {

    @Reference(version = "1.0.0")
    CleaningPService cleaningPService;

    @Reference(version = "1.0.0")
    CleaningTService cleaningTService;

    BaseTableController<CleaningPService, CleaningTService, CleaningDTO, CleaningTDTO, Cleaning, CleaningT, CleaningParam> bt = new BaseTableController<>();

    /**
     * 获取
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<CleaningTDTO>> info() {
        CleaningTDTO cleaningTDTO=new CleaningTDTO();
        return bt.info(cleaningTService, cleaningTDTO);
    }

    /**
     * 添加
     *
     * @param cleaningParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody CleaningParam cleaningParam) {
        Cleaning cleaning=new Cleaning();
        return bt.add(cleaningPService, cleaning, cleaningParam);
    }

    /**
     * 更新
     *
     * @param cleaningDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody CleaningDTO cleaningDTO) {
        return bt.update(cleaningPService, new Cleaning(), cleaningDTO);
    }

    /**
     * 删除
     *
     * @param cleaningDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody CleaningDTO cleaningDTO) {
        Long id = cleaningDTO.getId();
        return bt.delete(cleaningPService, id);
    }
}
