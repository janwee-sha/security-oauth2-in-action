package com.janwee.authorizationserver.entity.web.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Function: XXX. <br/>
 * date: 2020年5月24日 下午4:22:11 <br/>
 *
 * @author Jan-wee Sha
 * @since jdk1.8.0_92
 */
@ApiModel(value = "UserReq")
@Getter
@Setter
@NoArgsConstructor
public class UserReq implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1336892060523913748L;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private String phonenumber;
}
