package com.application.apigateway.service.auth;


import com.application.apigateway.payload.request.LoginRequest;
import com.application.apigateway.payload.request.SignupRequest;
import com.application.apigateway.payload.response.CommonResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    CommonResponse registerUser(SignupRequest signupReq);

    CommonResponse loginUser(LoginRequest loginRequest);
}
