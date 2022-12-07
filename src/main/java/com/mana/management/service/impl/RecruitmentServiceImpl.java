package com.mana.management.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mana.management.dao.RecruitmentDao;
import com.mana.management.enums.ResultEnum;
import com.mana.management.exception.BaseException;
import com.mana.management.pojo.Recruitment;
import com.mana.management.service.RecruitmentService;
import com.mana.management.vo.input.RecruitmentForm;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
@Service
@CacheConfig(cacheNames = "recruitment")
public class RecruitmentServiceImpl implements RecruitmentService {

    @Resource
    RecruitmentDao recruitmentDao;

    @Override
    @Cacheable(key = "#departmentName+'-'+#recruitStatus+'-'+#workStatus+'-'+#pageNum+'-'+#pageSize")
    public PageInfo<Recruitment> findAll(String departmentName, int recruitStatus, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        if (ObjectUtils.isEmpty(departmentName)) {
            departmentName = null;
        }
        List<Recruitment> personalSalaries = recruitmentDao.selectAll(departmentName, recruitStatus);
        return new PageInfo<>(personalSalaries);
    }
    @Override
    @Cacheable(key = "#root.methodName")
    public List<Recruitment> all() {
        return recruitmentDao.selectAll(null, 0);
    }

    @Override
    public Recruitment find(int id) {
        Recruitment recruitment = recruitmentDao.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(recruitment)) {
            throw new BaseException(ResultEnum.RECRUIT_NOT_EXIST);
        }
        return recruitment;
    }

    @Override
    @CacheEvict(allEntries = true)
    public void insert(RecruitmentForm recruitmentForm) {
        Recruitment recruitment = new Recruitment();
        BeanUtils.copyProperties(recruitmentForm,recruitment);
        recruitmentDao.insertSelective(recruitment);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteById(Integer id) {
        Recruitment recruitment = recruitmentDao.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(recruitment)) {
            throw new BaseException(ResultEnum.RECRUIT_NOT_EXIST);
        }
        recruitmentDao.deleteByPrimaryKey(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteByIdIn(Collection<Integer> idList) {
        recruitmentDao.deleteByIdIn(idList);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void updateById(Integer id, RecruitmentForm recruitmentForm) {
        Recruitment recruitment = recruitmentDao.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(recruitment)) {
            throw new BaseException(ResultEnum.RECRUIT_NOT_EXIST);
        }
        BeanUtils.copyProperties(recruitmentForm,recruitment);
        recruitmentDao.updateByPrimaryKeySelective(recruitment);
    }
}
