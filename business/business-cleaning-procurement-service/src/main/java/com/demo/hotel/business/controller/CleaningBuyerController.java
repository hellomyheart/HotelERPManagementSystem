package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.CleaningBuyerDTO;
import com.demo.hotel.business.dto.param.CleaningBuyerParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.CleaningBuyerService;
import com.demo.hotel.provider.domain.CleaningBuyer;
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
@RequestMapping(value = "cleaningProcurement/buyer")
@RestController
public class CleaningBuyerController {

    @Reference(version = "1.0.0")
    CleaningBuyerService cleaningBuyerService;

    BaseSingleTableController<CleaningBuyerService, CleaningBuyerDTO, CleaningBuyer, CleaningBuyerParam> bs = new BaseSingleTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<CleaningBuyerDTO>> info() {
        return bs.info(cleaningBuyerService, new CleaningBuyerDTO());
    }

    /**
     * 添加
     * @param cleaningBuyerParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody CleaningBuyerParam cleaningBuyerParam) {
        return bs.add(cleaningBuyerService, new CleaningBuyer(), cleaningBuyerParam);
    }

    /**
     * 更新
     * @param cleaningBuyerDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody CleaningBuyerDTO cleaningBuyerDTO) {
        return bs.update(cleaningBuyerService, new CleaningBuyer(), cleaningBuyerDTO);
    }

    /**
     * 删除
     * @param cleaningBuyerDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody CleaningBuyerDTO cleaningBuyerDTO) {
        Long id = cleaningBuyerDTO.getId();
        return bs.delete(cleaningBuyerService, id);
    }
}
