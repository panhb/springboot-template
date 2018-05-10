package com.panhb.dao;

import com.panhb.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author panhb
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
