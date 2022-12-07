package com.mana.management.service;

import com.github.pagehelper.PageInfo;
import com.mana.management.vo.PersonalSelectVo;
import com.mana.management.vo.PersonalVo;
import com.mana.management.vo.input.PersonalForm;

import java.util.Collection;
import java.util.List;

public interface PersonalService {

    PageInfo<PersonalVo> findAll(int pageNum, int pageSize, int departmentId, String personalName, int workStatus);
    List<PersonalVo> All();

    List<PersonalSelectVo> findSelect();

    PersonalVo find(int id);

    void insert(PersonalForm personalForm);

    void deleteById(Integer id);

    void deleteByIdIn(Collection<Integer> idList);

    void updateById(Integer id, PersonalForm personalForm);
}
