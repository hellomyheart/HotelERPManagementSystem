package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.TableDTO;
import com.demo.hotel.business.dto.param.BaseParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: 基础的Feign
 * @author: syj
 * @create: 2020-04-23 09:40
 * @param <T> param
 * @param <U> DTO
 */
public interface BaseFeign<T extends BaseParam, U extends TableDTO> {

    /**
     * 获取
     *
     * @return
     */
    @GetMapping(value = "info")
    String info();

    /**
     * 新增
     *
     * @param t
     * @return
     */
    @PostMapping(value = "add")
    String add(@RequestBody T t);


    /**
     * 修改
     *
     * @param u
     * @return
     */
    @PostMapping(value = "update")
    String update(@RequestBody U u);

    /**
     * 删除
     *
     * @param u
     * @return
     */
    @PostMapping(value = "delete")
    String delete(@RequestBody U u);

}
