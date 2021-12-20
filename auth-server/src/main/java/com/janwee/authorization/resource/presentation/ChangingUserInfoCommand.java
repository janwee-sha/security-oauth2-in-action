package com.janwee.authorization.resource.presentation;

import com.janwee.authorization.domain.User;
import io.swagger.annotations.ApiModelProperty;

public class ChangingUserInfoCommand {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "电话号码")
    private String phoneNumber;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User toUser() {
        return new User(username, password, phoneNumber);
    }
}
