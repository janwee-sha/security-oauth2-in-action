package com.janwee.authorization.assembler;

import com.janwee.authorization.entity.domain.User;
import com.janwee.authorization.api.entity.web.req.UserReq;
import com.janwee.authorization.api.entity.web.res.UserRes;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAssembler {
    public UserRes toView(User user) {
        UserRes userRes = new UserRes();
        BeanUtils.copyProperties(user, userRes);
        return userRes;
    }

    public List<UserRes> toViews(List<User> users) {
        return users.stream().map(this::toView).collect(Collectors.toList());
    }

    public User toDomain(UserReq userReq) {
        User user = new User();
        BeanUtils.copyProperties(userReq, user);
        return user;
    }
}
