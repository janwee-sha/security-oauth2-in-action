package com.janwee.authorizationserverapi.entity.web.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@ApiModel(value = "UserRes")
@Getter
@Setter
@NoArgsConstructor
public class UserRes implements Serializable {
    private static final long serialVersionUID = 478618525787182316L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "电话号码")
    private String phonenumber;
}
