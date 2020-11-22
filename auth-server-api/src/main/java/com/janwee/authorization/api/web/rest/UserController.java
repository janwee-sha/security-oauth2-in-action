package com.janwee.authorization.api.web.rest;

import com.janwee.authorization.api.entity.web.req.UserReq;
import com.janwee.authorization.api.entity.web.res.UserRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"User Management API"})
@RequestMapping("/user")
@FeignClient("auth-server")
public interface UserController {
    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    UserRes register(@ApiParam("*用户请求实体") @RequestBody UserReq userReq) throws Exception;

    @PutMapping("/edit")
    @ApiOperation(value = "修改用户")
    UserRes update(@ApiParam("*用户请求实体") @RequestBody UserReq userReq) throws Exception;

    @GetMapping("/{username}")
    @ApiOperation(value = "查询用户")
    UserRes readByUsername(
            @ApiParam("*用户名") @PathVariable(value = "username") String username) throws Exception;

    @GetMapping
    @ApiOperation(value = "查询所有用户")
    List<UserRes> readAll() throws Exception;
}
