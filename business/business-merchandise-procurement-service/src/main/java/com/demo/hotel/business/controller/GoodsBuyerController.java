package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.GoodsBuyerDTO;
import com.demo.hotel.business.dto.param.GoodsBuyerParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.GoodsBuyerService;
import com.demo.hotel.provider.domain.GoodsBuyer;
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
@RequestMapping(value = "merchandiseProcurement/buyer")
@RestController
public class GoodsBuyerController {

    @Reference(version = "1.0.0")
    GoodsBuyerService goodsBuyerService;

    BaseSingleTableController<GoodsBuyerService, GoodsBuyerDTO, GoodsBuyer, GoodsBuyerParam> bs = new BaseSingleTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<GoodsBuyerDTO>> info() {
        return bs.info(goodsBuyerService, new GoodsBuyerDTO());
    }

    /**
     * 添加
     *
     * @param goodsBuyerParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody GoodsBuyerParam goodsBuyerParam) {

        GoodsBuyer goodsBuyer = new GoodsBuyer();
        return bs.add(goodsBuyerService, goodsBuyer, goodsBuyerParam);
    }

    /**
     * 更新
     * @param goodsBuyerDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody GoodsBuyerDTO goodsBuyerDTO) {
        return bs.update(goodsBuyerService, new GoodsBuyer(), goodsBuyerDTO);
    }

    /**
     * 删除
     * @param goodsBuyerDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody GoodsBuyerDTO goodsBuyerDTO) {
        Long id = goodsBuyerDTO.getId();
        return bs.delete(goodsBuyerService, id);
    }
}
