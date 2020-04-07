package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.Training;

/**
 * @author syj
 */
public interface TrainingService {

    /**
     * 新增
     *
     * @param training
     * @return
     */
    int insert(Training training);

    /**
     * 修改
     *
     * @param training
     * @return
     */
    int update(Training training);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Long id);




}
