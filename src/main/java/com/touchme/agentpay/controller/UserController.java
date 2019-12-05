package com.touchme.agentpay.controller;


import com.touchme.agentpay.common.http.ResponseVo;
import com.touchme.agentpay.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liyy
 * @since 2019-12-05
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户接口")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    /**
     * 项目日志管理-编辑
     *
     * @return
     */
    @GetMapping("/get/{id}")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public ResponseVo getUser(@PathVariable Integer id) {
        return ResponseVo.ok(userService.getUser(id));
    }

}

