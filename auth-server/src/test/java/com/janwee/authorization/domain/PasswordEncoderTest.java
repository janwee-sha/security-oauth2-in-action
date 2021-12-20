package com.janwee.authorization.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordEncoderTest {
    private static final String TEST_STRING = "p@SSw0Rd1";
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Test
    public void shouldMatch() {
        String encodedString = passwordEncoder.encode(TEST_STRING);
        System.out.println(encodedString);
        assertTrue(passwordEncoder.matches(TEST_STRING, encodedString));
    }
}
