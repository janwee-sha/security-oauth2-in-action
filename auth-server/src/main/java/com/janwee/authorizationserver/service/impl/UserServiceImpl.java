package com.janwee.authorizationserver.service.impl;

import com.janwee.authorizationserver.assembler.UserAssembler;
import com.janwee.authorizationserver.entity.domain.User;
import com.janwee.authorizationserver.repository.UserRepository;
import com.janwee.authorizationserver.service.UserService;
import com.janwee.authorizationserverapi.entity.web.req.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepo;
    private UserAssembler userAssembler;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, UserAssembler userAssembler) {
        this.userRepo = userRepo;
        this.userAssembler = userAssembler;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findById(username).orElseThrow(() ->
                new UsernameNotFoundException("User '" + username + "' not found"));
    }

    public User register(UserReq userReq) {
        return save(userAssembler.toDomain(userReq));
    }

    @Override
    public User update(UserReq userReq) {
        return save(userAssembler.toDomain(userReq));
    }

    protected User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> loadAll() {
        return userRepo.findAll();
    }
}
