package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.CleaningDTO;
import com.demo.hotel.business.dto.param.NullParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.CleaningService;
import com.demo.hotel.provider.domain.Cleaning;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "cleaning/inventory")
@RestController
public class CleaningController {

    @Reference(version = "1.0.0")
    CleaningService cleaningService;

    BaseSingleTableController<CleaningService, CleaningDTO, Cleaning, NullParam> bs = new BaseSingleTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<CleaningDTO>> info() {
        return bs.info(cleaningService, new CleaningDTO());
    }


    /**
     * 更新信息
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody CleaningDTO dTO) {
        Cleaning cleaning = new Cleaning();
        return bs.update(cleaningService, cleaning, dTO);
    }
}
