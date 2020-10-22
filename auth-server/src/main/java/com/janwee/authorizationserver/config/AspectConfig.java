package com.janwee.authorizationserver.config;

import com.janwee.authorizationserver.aspect.UserPasswordEncoder;
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
