package com.mana.management.service;
import com.github.pagehelper.PageInfo;
import com.mana.management.pojo.Department;
import com.mana.management.vo.DepartmentSelectVo;
import com.mana.management.vo.input.DepartmentForm;

import java.util.Collection;
import java.util.List;

public interface DepartmentService {

    PageInfo<Department> findAll(int pageNum, int pageSize);
    List<Department> all();

    List<DepartmentSelectVo> findSelect();

    PageInfo<Department> search(String departmentName, int pageNum, int pageSize);

    Department find(int id);

    void insert(DepartmentForm departmentForm);

    void deleteById(Integer id);

    void deleteByIdIn(Collection<Integer> idList);

    void updateById(Integer id, DepartmentForm departmentForm);
}
