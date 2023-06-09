package com.springbootPOC.repository;

import com.springbootPOC.dbo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author mamta.t
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select count(u)>0  from User u where u.id=:userId")
    boolean existsByUserId(@Param("userId") int userId);
    Optional<User> findByEmail(String email);
}
