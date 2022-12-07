package com.mana.management.service;

import com.github.pagehelper.PageInfo;
import com.mana.management.pojo.PersonalSalary;
import com.mana.management.vo.input.PersonalSalaryForm;

import java.util.Collection;
import java.util.List;

public interface PersonalSalaryService {
    PageInfo<PersonalSalary> findAll(int year, int month, String departmentName, int personalId, int pageNum, int pageSize);
    List<PersonalSalary> all();

    PersonalSalary find2(int id);

    void insert(PersonalSalaryForm personalSalaryForm);

    void deleteById(Integer id);

    void deleteByIdIn(Collection<Integer> idList);

    void updateById(Integer id, PersonalSalaryForm personalSalaryForm);
}
