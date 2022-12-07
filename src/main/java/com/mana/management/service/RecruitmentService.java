package com.mana.management.service;

import com.github.pagehelper.PageInfo;
import com.mana.management.pojo.Recruitment;
import com.mana.management.vo.input.RecruitmentForm;

import java.util.Collection;
import java.util.List;

public interface RecruitmentService {
    PageInfo<Recruitment> findAll(String departmentName, int recruitStatus, int pageNum, int pageSize);
    List<Recruitment> all();

    Recruitment find(int id);

    void insert(RecruitmentForm recruitmentForm);

    void deleteById(Integer id);

    void deleteByIdIn(Collection<Integer> idList);

    void updateById(Integer id, RecruitmentForm recruitmentForm);
}
