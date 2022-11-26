package com.mana.management.dao;

import com.mana.management.pojo.User;
import com.mana.management.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;


public interface UserDao {

    int deleteByPrimaryKey(Integer id);


    int insert(User record);


    int insertSelective(User record);


    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);


    int updateByPrimaryKey(User record);

    User selectByUsername(@Param("username") String username);

    List<UserVo> selectAll();

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);
}