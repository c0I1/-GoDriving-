package com.mana.management.dao;

import com.mana.management.pojo.Department;
import com.mana.management.vo.DepartmentSelectVo;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface DepartmentDao {

    int deleteByPrimaryKey(Integer id);


    int insert(Department record);


    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Department record);


    int updateByPrimaryKey(Department record);

    List<Department> selectAll();

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);

    List<Department> selectAllByDepartmentNameLike(@Param("departmentName") String departmentName);

    List<DepartmentSelectVo> selectAllSelect();
}