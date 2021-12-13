package com.janwee.authorization.resource.presentation;

import com.janwee.authorization.domain.User;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class RegisteringUserCommand implements Serializable {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "电话号码")
    private String phoneNumber;

    public User toUser() {
        return new User(username, password, phoneNumber);
    }

}
