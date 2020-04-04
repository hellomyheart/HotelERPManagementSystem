package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.Department;

import java.util.List;

/**
 * @author syj
 */
public interface DepartmentService{
    /**
     * 新增
     * @param department
     * @return
     */
    int insert(Department department);

    /**
     * 修改
     * @param department
     * @return
     */
    int update(Department department);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 查询所有
     * @return
     */
    List<Department> selectAll();

}
