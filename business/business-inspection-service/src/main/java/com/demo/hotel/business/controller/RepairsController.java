package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.InspectionDTO;
import com.demo.hotel.business.dto.RepairsDTO;
import com.demo.hotel.business.dto.param.InspectionParam;
import com.demo.hotel.business.dto.param.RepairsParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.InspectionService;
import com.demo.hotel.provider.api.RepairsService;
import com.demo.hotel.provider.domain.Inspection;
import com.demo.hotel.provider.domain.Repairs;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "inspection/repairs")
@RestController
public class RepairsController {

    @Reference(version = "1.0.0")
    RepairsService service;

    BaseSingleTableController<RepairsService, RepairsDTO, Repairs, RepairsParam> bs = new BaseSingleTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<RepairsDTO>> info() {
        return bs.info(service, new RepairsDTO());
    }

    /**
     * 添加信息
     *
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody RepairsParam param) {
        Repairs repairs = new Repairs();
        BeanUtils.copyProperties(param, repairs);
        repairs.setRepairsTime(new Date());
        return bs.add(service, repairs);
    }

    /**
     * 更新信息
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody RepairsDTO dTO) {
        Repairs repairs = new Repairs();
        return bs.update(service, repairs, dTO);
    }

    /**
     * 删除
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody RepairsDTO dTO) {
        Long id = dTO.getId();
        return bs.delete(service, id);
    }
}
