package com.mana.management.dao;

import com.mana.management.pojo.PersonalReward;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;


public interface PersonalRewardDao {

    int deleteByPrimaryKey(Integer id);


    int insert(PersonalReward record);


    int insertSelective(PersonalReward record);


    PersonalReward selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(PersonalReward record);

    int updateByPrimaryKey(PersonalReward record);

    List<PersonalReward> selectAll(@Param("year") int year, @Param("month") int month,
                                   @Param("departmentName") String departmentName, @Param("personalId") int personalId);

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);
}