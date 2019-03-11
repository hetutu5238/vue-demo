package com.vuetest.vueproject.service.impl;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.vuetest.vueproject.data.DataCache;
import com.vuetest.vueproject.entity.User;
import com.vuetest.vueproject.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: zhoum
 * @Date: 2019-03-11
 * @Time: 17:35
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public void save(User user) {
        DataCache.list.add(user);
    }

    @Override
    public void update(User user) {
        DataCache.list.removeIf(x->x.getcId().equals(user.getcId()));
        DataCache.list.add(user);
    }

    @Override
    public List<User> listUser(String filter) {

        return DataCache.list.stream().filter(x-> StringUtils.isBlank(filter) || StringUtils.contains(x.getcUsername(),filter)).collect(Collectors.toList());
    }

    @Override
    public void deleteByPrimarykey(String userId) {
        DataCache.list.removeIf(x->x.getcId().equals(userId));
    }
}
