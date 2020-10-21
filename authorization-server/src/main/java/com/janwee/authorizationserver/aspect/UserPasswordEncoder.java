package com.janwee.authorizationserver.aspect;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class UserPasswordEncoder {

   /* @Autowired
    private PasswordEncoder passwordEncoder;


    @Pointcut("execution(* com.janwee.authorizationserver.web.rest.UserControllerImpl.create("
            + "com.janwee.authorizationserver.entity.web.req.UserReq)) && args(userReq)")
    public void create(UserReq userReq) {
    }


    @Pointcut("execution(* com.janwee.authorizationserver.web.rest.UserControllerImpl.update(java.lang.String,"
            + "com.janwee.authorizationserver.entity.web.req.UserReq)) && args(username,userReq)")
    public void update(String username, UserReq userReq) {
    }

    @Before("create(userReq)")
    public void createEncodePassword(UserReq userReq) {
        userReq.setPassword(passwordEncoder.encode(userReq.getPassword()));
    }

    @Before("update(username,userReq)")
    public void updateEncodePassword(String username, UserReq userReq) {
        userReq.setPassword(passwordEncoder.encode(userReq.getPassword()));
    }*/
}
