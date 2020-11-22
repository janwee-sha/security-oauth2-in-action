package com.janwee.authorization.entity.web.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@ApiModel(value = "UserReq")
@Getter
@Setter
@NoArgsConstructor
public class UserReq implements Serializable {

    private static final long serialVersionUID = -1336892060523913748L;

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "电话号码")
    private String phonenumber;
}
