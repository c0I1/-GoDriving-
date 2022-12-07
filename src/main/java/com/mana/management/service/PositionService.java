package com.mana.management.service;

import com.github.pagehelper.PageInfo;
import com.mana.management.pojo.Position;
import com.mana.management.vo.PositionSelectVo;
import com.mana.management.vo.PositionVo;
import com.mana.management.vo.input.PositionForm;

import java.util.Collection;
import java.util.List;

public interface PositionService {
    PageInfo<PositionVo> findAll(int pageNum, int pageSize, int departmentId, String positionName);
    List<PositionVo> all();

    Position find(int id);

    void insert(PositionForm positionForm);

    void deleteById(Integer id);

    void deleteByIdIn(Collection<Integer> idList);

    void updateById(Integer id, PositionForm positionForm);

    List<PositionSelectVo> findSelect(Integer departmentId);
}
