package com.janwee.authorization.resource.presentation;

import com.janwee.authorization.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.io.Serializable;

@ApiModel("用户展现对象")
@Getter
public class UserPresentation implements Serializable {
    private static final long serialVersionUID = 478618525787182316L;

    @ApiModelProperty(value = "用户名")
    private final String username;

    @ApiModelProperty(value = "电话号码")
    private final String phoneNumber;

    public UserPresentation(String username, String phoneNumber) {
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public static UserPresentation fromUser(User user) {
        return new UserPresentation(user.getUsername(), user.getPhonenumber());
    }
}
