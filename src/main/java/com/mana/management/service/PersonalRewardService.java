package com.mana.management.service;


import com.github.pagehelper.PageInfo;
import com.mana.management.pojo.PersonalReward;
import com.mana.management.vo.input.PersonalRewardForm;

import java.util.Collection;
import java.util.List;

public interface PersonalRewardService {

    PageInfo<PersonalReward> findAll(int year, int month, String departmentName, int personalId, int pageNum, int pageSize);
    List<PersonalReward> all();

    PersonalReward find(int id);

    void insert(PersonalRewardForm personalRewardForm);

    void deleteById(Integer id);

    void deleteByIdIn(Collection<Integer> idList);

    void updateById(Integer id, PersonalRewardForm personalRewardForm);
}
