package com.panhb.dao;

import com.panhb.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author panhb
 */
@Transactional(rollbackFor = Exception.class)
public interface UserDao extends JpaRepository<User, Integer> {

}
