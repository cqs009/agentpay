package com.touchme.agentpay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.touchme.agentpay.entity.User;
import com.touchme.agentpay.mapper.UserMapper;
import com.touchme.agentpay.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Impl
 *
 * @author liyy
 * 2019-12-05
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.selectById(id);
    }
}
