package com.janwee.authorization.config;

import com.janwee.authorization.aspect.UserPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
    @Bean
    public UserPasswordEncoder userPasswordEncoder() {
        return new UserPasswordEncoder();
    }
}
