package com.janwee.authorizationserver.web.rest;

import com.janwee.authorizationserver.entity.domain.User;
import com.janwee.authorizationserver.entity.web.req.UserReq;
import com.janwee.authorizationserver.entity.web.res.UserRes;
import com.janwee.authorizationserver.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Function: 用户视图RESTful控制器. <br/>
 * date: 2020年5月24日 下午1:28:39 <br/>
 *
 * @author Jan-wee Sha
 * @since jdk1.8.0_92
 */
@RestController
@RequestMapping("/users")
public class UserController {
    /**
     *
     */
    private UserService userService;

    /**
     * @param userService 用户服务
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param userReq 用户请求对象
     * @return 用户视图对象
     */
    @PostMapping("/register")
    @ApiOperation(value = "注册用户", notes = "根据给定用户信息注册用户")
    public UserRes create(@ApiParam("*用户请求实体") @RequestBody UserReq userReq) {
        return Optional.ofNullable(userService.create(new User(userReq))).map(UserRes::new).orElse(null);
    }

    /**
     * 根据给定用户信息修改用户
     *
     * @param userReq 用户请求对象
     * @return 用户结果对象
     */
    @PutMapping("/edit")
    @ApiOperation(value = "修改用户", notes = "根据给定用户信息修改用户")
    public UserRes update(@ApiParam("*用户请求实体") @RequestBody UserReq userReq) {
        return Optional.ofNullable(userService.update(new User(userReq))).map(UserRes::new).orElse(null);
    }

    /**
     * @param username 用户名
     * @return 用户
     */
    @GetMapping("/{username}")
    @ApiOperation(value = "查询用户", notes = "根据给定用户名查询用户")
    public UserRes readByUsername(
            @ApiParam("*用户名") @PathVariable(value = "username") String username) {
        return Optional.ofNullable(userService.loadUserByUsername(username))
                .map(domainEntity -> new UserRes((User) domainEntity)).orElse(null);
    }

    /**
     * @return 用户视图对象集合
     */
    @GetMapping
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    public List<UserRes> readAll() {
        return userService.loadAll().stream().map(UserRes::new).collect(Collectors.toList());
    }
}
