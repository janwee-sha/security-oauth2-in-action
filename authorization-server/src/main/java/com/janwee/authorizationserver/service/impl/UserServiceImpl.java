package com.janwee.authorizationserver.service.impl;

import com.janwee.authorizationserver.entity.domain.User;
import com.janwee.authorizationserver.repository.UserRepository;
import com.janwee.authorizationserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Function: 用户服务实现. <br/>
 * date: 2020年5月24日 下午2:41:32 <br/>
 *
 * @author Jan-wee Sha
 * @since jdk1.8.0_92
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    /**
     * UserRepository
     */
    private UserRepository userRepository;

    /**
     * 有参构造
     *
     * @param userRepository UserRepository
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' not found"));
    }

    public User create(User user) {
        return save(user);
    }

    /**
     * 更新用户对象
     *
     * @param user 用户对象
     * @return 更新后的用户对象
     */
    @Override
    public User update(User user) {
        return save(user);
    }

    protected User save(User user) {
        return userRepository.save(user);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.janwee.service.UserService#loadAll()
     */
    @Override
    public List<User> loadAll() {
        return userRepository.findAll();
    }
}
