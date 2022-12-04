package com.mana.management.service;

import com.github.pagehelper.PageInfo;
import com.mana.management.pojo.Role;
import com.mana.management.pojo.User;
import com.mana.management.vo.UserVo;

import java.util.Collection;
import java.util.List;

public interface UserService {

    User findByUsername(String username);

    User find(int id);

    PageInfo<UserVo> findList(int pageNum, int pageSize);

    void deleteById(int id);

    void deleteByIdIn(Collection<Integer> idList);

    void insert(User user);

    void updateById(User user);

    List<Role> roleList();
}
