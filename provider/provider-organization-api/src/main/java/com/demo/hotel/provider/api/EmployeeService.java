package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.Employee;

/**
 * @author syj
 */
public interface EmployeeService{

    /**
     * 新增
     * @param employee
     * @return
     */
    int insert(Employee employee);

    /**
     * 修改
     * @param employee
     * @return
     */
    int update(Employee employee);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);

}
