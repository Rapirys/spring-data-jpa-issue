package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
           SELECT /* Multi-line comment
                     spanning multiple lines */
           u FROM User u
           WHERE /* Inline comment */ u.email IS NOT NULL
           """)
    List<User> findUsersWithEmail();
}

