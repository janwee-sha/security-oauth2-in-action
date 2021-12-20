package com.janwee.authorization.infrastructure.config;

import com.janwee.authorization.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig implements AuthorizationServerConfigurer {
    private final static String KEY_PATH = "mykeypair.jks";
    private final static String KEY_ALIAS = "mykeypair.jks";
    private final static String KEY_PASS = "janwee";
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;

    @Autowired
    public AuthorizationServerConfig(@Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager,
                                     UserService userService, PasswordEncoder passwordEncoder, DataSource dataSource) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userService;
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
    }

    //授权服务器安全配置
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(passwordEncoder).tokenKeyAccess("permitAll()");
    }

    //注册客户
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //没有配置客户端的持久化数据，使用内存数据源
        //clients.jdbc(dataSource);
        clients.inMemory()
                .withClient("janwee")
                .authorizedGrantTypes("refresh_token", "password")
                .scopes("read", "write")
                .secret("$2a$10$zAtKQOqE.J9w3WjuMLNexuqUQWeTbd1sWHp25F/pQp40BRcQ3pCzO")
                .autoApprove(true);
    }


    //配置授权服务器使用JwtTokenStore
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter())
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);


    }

    //使用非对称密钥对中的私钥（Private Key）来签署JWT令牌
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyStoreKeyFactory keyStoreKeyFactory =
                new KeyStoreKeyFactory(new ClassPathResource(KEY_PATH), KEY_PASS.toCharArray());
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair(KEY_ALIAS));
        return converter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
}
