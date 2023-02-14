package com.example.cambridge.service.user;

import com.example.cambridge.entity.user.User;
import com.example.cambridge.entity.user.UserType;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);

}
