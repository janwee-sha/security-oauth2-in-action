package com.janwee.authorizationserver.entity.web.res;

import com.janwee.authorizationserver.entity.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * Function: 用户视图类型. <br/>
 * date: 2020年5月24日 下午4:22:11 <br/>
 *
 * @author Jan-wee Sha
 * @since jdk1.8.0_92
 */
@ApiModel(value = "UserRes")
@Getter
@Setter
@NoArgsConstructor
public class UserRes implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 478618525787182316L;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;
    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private String phonenumber;

    /**
     * 构造方法
     *
     * @param user User
     */
    public UserRes(User user) {
        super();
        BeanUtils.copyProperties(user, this);
    }
}
