package com.janwee.authorizationserver.entity.domain;

import com.janwee.authorizationserver.entity.web.req.UserReq;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collection;

/**
 * Function: 系统登录用户. <br/>
 * date: 2020年5月24日 下午2:00:57 <br/>
 *
 * @author Jan-wee Sha
 * @since jdk1.8.0_92
 */
@Entity
@Table(name = "USER_ACCOUNT")
@Data
@NoArgsConstructor
public class User implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 8714730354004022226L;
    /**
     * 用户名
     */
    @Id
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话号码
     */
    private String phonenumber;

    /**
     * 构造方法
     *
     * @param username 用户名
     */
    public User(String username) {
        super();
        this.username = username;
    }

    /**
     * @param userReq 用户请求对象
     */
    public User(UserReq userReq) {
        BeanUtils.copyProperties(userReq, this);
    }

    /**
     *
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    /**
     *
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     *
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     *
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
