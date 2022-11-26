package com.mana.management.dao;
import com.mana.management.pojo.Recruitment;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;


public interface RecruitmentDao {

    int deleteByPrimaryKey(Integer id);


    int insert(Recruitment record);


    int insertSelective(Recruitment record);


    Recruitment selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Recruitment record);

    int updateByPrimaryKey(Recruitment record);

    List<Recruitment> selectAll(@Param("departmentName") String departmentName, @Param("recruitStatus") Integer recruitStatus);

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);
}