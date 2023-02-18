package com.example.cambridge.repo.user;

import com.example.cambridge.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<UserDetails> findByUserName(String userName);
    User getByUserName(String userName);

}
