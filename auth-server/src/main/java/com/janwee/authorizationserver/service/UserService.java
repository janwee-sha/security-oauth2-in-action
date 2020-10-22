package com.janwee.authorizationserver.service;

import com.janwee.authorizationserver.entity.domain.User;
import com.janwee.authorizationserverapi.entity.web.req.UserReq;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User register(UserReq userReq);

    User update(UserReq userReq);

    List<User> loadAll();
}
