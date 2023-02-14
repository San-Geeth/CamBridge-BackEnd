package com.example.cambridge.repo.user;

import com.example.cambridge.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
