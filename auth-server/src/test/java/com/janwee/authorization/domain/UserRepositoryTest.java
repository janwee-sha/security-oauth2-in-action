package com.janwee.authorization.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserRepositoryTest {
    private static final String USER_NAME_1 = "user1", USER_NAME_2 = "user2";
    private static final String PASSWORD1 = "p@ssWoRd1";
    private static final String DUMMY_STRING = "Dummy";
    private User user1;
    @Autowired
    private UserRepository userRepo;

    @BeforeEach
    public void setUp() {
        user1 = new User(USER_NAME_1, PASSWORD1, DUMMY_STRING);
        userRepo.deleteUser(USER_NAME_1);
    }

    @AfterEach
    public void cleanUp() {
        userRepo.deleteUser(USER_NAME_1);
    }

    @Test
    @Transactional(rollbackFor = Throwable.class)
    public void shouldFind() {
        userRepo.addUser(user1);
        Optional<User> user1 = userRepo.userOfUsername(USER_NAME_1);
        assertTrue(user1.isPresent());
        Optional<User> user2 = userRepo.userOfUsername(USER_NAME_2);
        assertFalse(user2.isPresent());
    }
}
