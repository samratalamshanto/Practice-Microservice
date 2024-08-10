package com.application.apigateway.controller.auth;


import com.application.apigateway.payload.request.LoginRequest;
import com.application.apigateway.payload.request.SignupRequest;
import com.application.apigateway.payload.response.CommonResponse;
import com.application.apigateway.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public CommonResponse register(@RequestBody SignupRequest signupRequest) {
        return authService.registerUser(signupRequest);
    }

    @PostMapping("/login")
    public CommonResponse authenticate(@RequestBody LoginRequest loginRequest) {
        return authService.loginUser(loginRequest);
    }
}
