package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.TrainingEc;

import java.util.List;

/**
 * @author syj
 */
public interface TrainingEcService{

    /**
     * 查询所有
     * @return
     */
    List<TrainingEc> selectAll();

}
