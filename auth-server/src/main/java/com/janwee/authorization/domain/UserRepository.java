package com.janwee.authorization.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> userOfUsername(String username);

    List<User> users();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(String username);
}
