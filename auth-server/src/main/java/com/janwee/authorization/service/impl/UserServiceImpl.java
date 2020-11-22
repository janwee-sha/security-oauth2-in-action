package com.janwee.authorization.service.impl;

import com.janwee.authorization.assembler.UserAssembler;
import com.janwee.authorization.entity.domain.User;
import com.janwee.authorization.repository.UserRepository;
import com.janwee.authorization.service.UserService;
import com.janwee.authorization.api.entity.web.req.UserReq;
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
