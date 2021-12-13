package com.janwee.authorization.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findById(username).orElseThrow(() ->
                new UsernameNotFoundException("User '" + username + "' not found"));
    }

    public User register(User user) {
        return save(user);
    }

    public User changeUserInfo(User user) {
        return save(user);
    }

    protected User save(User user) {
        return userRepo.save(user);
    }

    public List<User> users() {
        return userRepo.findAll();
    }
}
