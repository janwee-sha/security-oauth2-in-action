package com.janwee.authorization.service;

import com.janwee.authorization.entity.domain.User;
import com.janwee.authorization.api.entity.web.req.UserReq;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User register(UserReq userReq);

    User update(UserReq userReq);

    List<User> loadAll();
}
