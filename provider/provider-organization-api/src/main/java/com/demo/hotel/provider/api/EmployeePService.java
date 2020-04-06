package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.EmployeeP;

import java.util.List;

/**
 * @author syj
 */
public interface EmployeePService{

    /**
     * 查询所有
     * @return
     */
    List<EmployeeP> selectAll();


}
