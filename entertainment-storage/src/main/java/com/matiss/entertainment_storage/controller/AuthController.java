package com.matiss.entertainment_storage.controller;

import com.matiss.entertainment_storage.dto.RegUserResponse;
import com.matiss.entertainment_storage.dto.RegisterRequest;
import com.matiss.entertainment_storage.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegUserResponse> register(@RequestBody @Valid RegisterRequest request) {
        RegUserResponse response = authService.register(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}