package com.matiss.entertainment_storage.service;

import com.matiss.entertainment_storage.dto.LoginRequest;
import com.matiss.entertainment_storage.dto.RegUserResponse;
import com.matiss.entertainment_storage.dto.RegisterRequest;
import com.matiss.entertainment_storage.model.User;
import com.matiss.entertainment_storage.repository.UserRepository;
import com.matiss.entertainment_storage.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public RegUserResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail());
        return new RegUserResponse(token, user.getUsername());
    }

    public RegUserResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password.");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new RegUserResponse(token, user.getUsername());
    }
}