package com.janwee.authorization.infrastructure.persistence;

import com.janwee.authorization.domain.User;
import com.janwee.authorization.domain.UserRepository;
import com.janwee.authorization.infrastructure.mybatismapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MyBatisUserRepository implements UserRepository {
    private final UserMapper userMapper;

    @Autowired
    public MyBatisUserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> userOfUsername(String username) {
        return Optional.ofNullable(userMapper.userOfUsername(username));
    }

    @Override
    public List<User> users() {
        return userMapper.users();
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String username) {
        userMapper.deleteUser(username);
    }
}
