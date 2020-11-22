package com.janwee.authorization.web.rest;

import com.janwee.authorization.assembler.UserAssembler;
import com.janwee.authorization.entity.domain.User;
import com.janwee.authorization.service.UserService;
import com.janwee.authorization.api.entity.web.req.UserReq;
import com.janwee.authorization.api.entity.web.res.UserRes;
import com.janwee.authorization.api.web.rest.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserControllerImpl implements UserController {
    private UserService userService;
    private UserAssembler userAssembler;

    @Autowired
    public UserControllerImpl(UserService userService, UserAssembler userAssembler) {
        this.userService = userService;
        this.userAssembler = userAssembler;
    }

    @Override
    public UserRes register(@RequestBody UserReq userReq) {
        return Optional.ofNullable(userService.register(userReq)).map(userAssembler::toView).orElse(null);
    }

    @Override
    public UserRes update(@RequestBody UserReq userReq) {
        return Optional.ofNullable(userService.update(userReq)).map(userAssembler::toView).orElse(null);
    }

    @Override
    public UserRes readByUsername(@PathVariable String username) {
        return Optional.ofNullable(userService.loadUserByUsername(username))
                .map(domainEntity -> userAssembler.toView((User) domainEntity)).orElse(null);
    }

    @Override
    public List<UserRes> readAll() {
        return userAssembler.toViews(userService.loadAll());
    }
}
