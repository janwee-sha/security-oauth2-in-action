package com.janwee.authorizationserver.service;

import com.janwee.authorizationserver.entity.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Function: 用户服务. <br/>
 * date: 2020年5月24日 下午3:30:25 <br/>
 *
 * @author Jan-wee Sha
 * @since jdk1.8.0_92
 */
public interface UserService extends UserDetailsService {
    /**
     * 创建用户对象
     *
     * @param user 用户对象
     * @return 用户结果对象
     */
    User create(User user);

    /**
     * 更新用户对象
     *
     * @param user 用户对象
     * @return 更新后的用户对象
     */
    User update(User user);

    /**
     * 查询所有用户对象
     *
     * @return 用户结果集
     */
    List<User> loadAll();
}
