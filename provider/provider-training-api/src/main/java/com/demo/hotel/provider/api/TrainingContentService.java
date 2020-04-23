package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.TrainingContent;

/**
 * @author syj
 */
public interface TrainingContentService extends BaseTableApi<TrainingContent> {

    /**
     * 查询单个信息
     * @param id
     * @return
     */
    TrainingContent searchByID(Long id);
}
