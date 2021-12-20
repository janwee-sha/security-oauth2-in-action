package com.janwee.authorization.application;

import com.janwee.authorization.domain.User;
import com.janwee.authorization.domain.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserAccountApplicationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAccountApplicationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true, rollbackFor = Throwable.class)
    public User user(String username) {
        try {
            return (User) userService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            log.error("用户名不存在");
            return null;
        }
    }

    @Transactional(readOnly = true, rollbackFor = Throwable.class)
    public List<User> users() {
        return userService.users();
    }

    @Transactional(rollbackFor = Throwable.class)
    public void register(User user) {
        user.encodePassword(passwordEncoder);
        userService.register(user);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void changeUserInfo(User user) {
        user.encodePassword(passwordEncoder);
        userService.changeUserInfo(user);
    }
}
