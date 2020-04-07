package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.TrainingContent;

/**
 * @author syj
 */
public interface TrainingContentService {
    /**
     * 新增
     *
     * @param trainingContent
     * @return
     */
    int insert(TrainingContent trainingContent);

    /**
     * 修改
     *
     * @param trainingContent
     * @return
     */
    int update(TrainingContent trainingContent);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 查询单个信息
     * @param id
     * @return
     */
    TrainingContent searchByID(Long id);


}
