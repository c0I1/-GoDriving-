package com.mana.management.service;


import com.github.pagehelper.PageInfo;
import com.mana.management.pojo.PersonalTrain;
import com.mana.management.vo.input.PersonalTrainForm;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface PersonalTrainService {
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param departmentName
     * @param personalId
     * @param beginDate
     * @param endDate
     * @return
     */
    PageInfo<PersonalTrain> findAll(int pageNum, int pageSize, String departmentName, int personalId, Date beginDate, Date endDate);

    /**
     * 查所有
     * @return
     */
    List<PersonalTrain> all();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    PersonalTrain find(int id);

    /**
     * 增加
     * @param personalTrainForm
     */
    void insert(PersonalTrainForm personalTrainForm);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 批量删除
     * @param idList
     */
    void deleteByIdIn(Collection<Integer> idList);

    /**
     * 更新
     * @param id
     * @param personalTrainForm
     */
    void updateById(Integer id, PersonalTrainForm personalTrainForm);
}
