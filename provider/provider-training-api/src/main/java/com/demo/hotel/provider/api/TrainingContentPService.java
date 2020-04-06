package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.TrainingContentP;

import java.util.List;

/**
 * @author syj
 */
public interface TrainingContentPService{

    /**
     * 查询所有
     * @return
     */
    List<TrainingContentP> selectAll();


}
