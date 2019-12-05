package com.touchme.agentpay.service;
import com.touchme.agentpay.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Manager
 * @author liyy
 * 2019-12-05
 */
public interface IUserService extends IService<User> {

    User getUser(Integer id);
}
