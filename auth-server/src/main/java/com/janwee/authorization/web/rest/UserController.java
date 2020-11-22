package com.janwee.authorization.web.rest;

import com.janwee.authorization.api.entity.web.req.UserReq;
import com.janwee.authorization.api.entity.web.res.UserRes;
import com.janwee.authorization.assembler.UserAssembler;
import com.janwee.authorization.entity.domain.User;
import com.janwee.authorization.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = {"User Management API"})
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserAssembler userAssembler;

    @Autowired
    public UserController(UserService userService, UserAssembler userAssembler) {
        this.userService = userService;
        this.userAssembler = userAssembler;
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    public UserRes register(@RequestBody UserReq userReq) {
        return Optional.ofNullable(userService.register(userReq)).map(userAssembler::toView).orElse(null);
    }

    @PutMapping("/edit")
    @ApiOperation(value = "修改用户")
    public UserRes update(@RequestBody UserReq userReq) {
        return Optional.ofNullable(userService.update(userReq)).map(userAssembler::toView).orElse(null);
    }

    @GetMapping("/{username}")
    @ApiOperation(value = "查询用户")
    public UserRes readByUsername(@PathVariable String username) {
        return Optional.ofNullable(userService.loadUserByUsername(username))
                .map(domainEntity -> userAssembler.toView((User) domainEntity)).orElse(null);
    }

    @GetMapping
    @ApiOperation(value = "查询所有用户")
    public List<UserRes> readAll() {
        return userAssembler.toViews(userService.loadAll());
    }
}
