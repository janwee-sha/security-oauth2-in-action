package com.janwee.authorizationserver.configuration;

import com.janwee.authorizationserver.aspect.UserPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Function: 切面配置. <br/>
 * date: 2020年3月10日 上午10:20:30 <br/>
 *
 * @author xiazhangwei
 * @since jdk1.8.0_92
 */

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
    /**
     * TripValidator注入容器
     *
     * @return TripValidator
     */
    @Bean
    public UserPasswordEncoder userPasswordEncoder() {
        return new UserPasswordEncoder();
    }
}
