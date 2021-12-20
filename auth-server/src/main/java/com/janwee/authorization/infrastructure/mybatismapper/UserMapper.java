package com.janwee.authorization.infrastructure.mybatismapper;

import com.janwee.authorization.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User userOfUsername(String username);

    List<User> users();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(String username);
}
