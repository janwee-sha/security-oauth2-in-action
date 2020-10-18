package com.janwee.authorizationserver.repository;

import com.janwee.authorizationserver.entity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Function: 系统登陆用户数据仓库. <br/>
 * date: 2020年5月24日 下午2:31:27 <br/>
 *
 * @author Jan-wee Sha
 * @since jdk1.8.0_92
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
