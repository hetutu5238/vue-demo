package com.vuetest.vueproject.service;

import com.vuetest.vueproject.entity.User;

import java.util.List;

/**
 * @Description:
 * @author: zhoum
 * @Date: 2019-03-11
 * @Time: 17:35
 */
public interface IUserService {
    void save(User user);

    void update(User user);

    List<User> listUser(String filter);

    void deleteByPrimarykey(String userId);
}
