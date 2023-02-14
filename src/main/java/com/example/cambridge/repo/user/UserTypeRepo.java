package com.example.cambridge.repo.user;

import com.example.cambridge.entity.user.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserTypeRepo extends JpaRepository<UserType, String> {
    @Query("SELECT u.type FROM UserType u WHERE u.type=:type")
    UserType getUserTypeById(String type);
}
