package com.example.cambridge.config.auth;

import com.example.cambridge.config.JwtService;
import com.example.cambridge.entity.user.Constants;
import com.example.cambridge.entity.user.User;
import com.example.cambridge.entity.user.enums.Role;
import com.example.cambridge.repo.user.UserRepo;
import com.example.cambridge.utility.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sangeethnawa
 * @createdOn 2/18/2023
 */
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public ResponseEntity authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        User user1 = userRepo.getByUserName(request.getUserName());
        var user = userRepo.findByUserName(request.getUserName())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        var jwtToken = jwtService.generateToken(user);
        AuthenticationResponse returnResponse = AuthenticationResponse.builder()
                .token(jwtToken)
                .user(user1)
                .build();

        if (user == null) {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(Constants.USER_FORBIDDEN));
        } else {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(returnResponse));

        }
    }
}
