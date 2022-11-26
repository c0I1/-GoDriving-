package com.mana.management.dao;

import com.mana.management.pojo.PersonalSalary;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;


public interface PersonalSalaryDao {

    int deleteByPrimaryKey(Integer id);


    int insert(PersonalSalary record);

    int insertSelective(PersonalSalary record);


    PersonalSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonalSalary record);

    int updateByPrimaryKey(PersonalSalary record);

    List<PersonalSalary> selectAll(
            @Param("year") Integer year, @Param("month") Integer month,
            @Param("departmentName") String departmentName, @Param("personalId") Integer personalId);

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);
}