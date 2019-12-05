package com.touchme.agentpay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.touchme.agentpay.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author liyy
 * 2019-12-05
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 保存或更新
     *
     * @param user
     * @author liyy
     * 2019-12-05
     */
    void saveOrUpdate(@Param("user") User user);

    /**
     * 批量保存
     *
     * @param userList
     * @author liyy
     * 2019-12-05
     */
    void batchSave(@Param("userList") List<User> userList);

    /**
     * 批量保存或更新
     *
     * @param userList
     * @author liyy
     * 2019-12-05
     */
    void batchSaveOrUpdate(@Param("userList") List<User> userList);
}