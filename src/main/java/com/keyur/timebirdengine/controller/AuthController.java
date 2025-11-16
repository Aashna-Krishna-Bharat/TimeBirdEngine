package com.keyur.timebirdengine.controller;

import com.keyur.timebirdengine.dto.LoginRequestDto;
import com.keyur.timebirdengine.dto.LoginResponseDto;
import com.keyur.timebirdengine.dto.SignUpRequestDto;
import com.keyur.timebirdengine.dto.SignupResponseDto;
import com.keyur.timebirdengine.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
    	System.out.println("***************** 24 ***********************************");
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignUpRequestDto signupRequestDto) {
        return ResponseEntity.ok(authService.signup(signupRequestDto));
    }
}
