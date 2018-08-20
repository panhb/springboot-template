package com.panhb.dao;

import com.panhb.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author panhb
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * 根据id查找
     *
     * @param id
     * @return Optional<User>
     */
    @Override
    Optional<User> findById(Long id);
}
