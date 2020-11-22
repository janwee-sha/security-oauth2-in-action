package com.janwee.authorization.aspect;

import com.janwee.authorization.api.entity.web.req.UserReq;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Aspect
public class UserPasswordEncoder {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Pointcut("execution(* com.janwee.authorization.web.rest.UserController.register("
            + "com.janwee.authorization.entity.web.req.UserReq)) && args(userReq)")
    public void create(UserReq userReq) {
    }


    @Pointcut("execution(* com.janwee.authorization.web.rest.UserController.update(java.lang.String,"
            + "com.janwee.authorization.entity.web.req.UserReq)) && args(username,userReq)")
    public void update(String username, UserReq userReq) {
    }

    @Before("create(userReq)")
    public void encodeRegistering(UserReq userReq) {
        userReq.setPassword(passwordEncoder.encode(userReq.getPassword()));
    }

    @Before("update(username,userReq)")
    public void encodeUpdating(String username, UserReq userReq) {
        userReq.setPassword(passwordEncoder.encode(userReq.getPassword()));
    }
}
