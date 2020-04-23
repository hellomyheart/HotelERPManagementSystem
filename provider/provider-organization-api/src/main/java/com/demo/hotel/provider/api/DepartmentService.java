package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.Department;

import java.util.List;

/**
 * @author syj
 */
public interface DepartmentService extends BaseTableApi<Department>{


    /**
     * 查询所有
     * @return
     */
    List<Department> selectAll();

}
