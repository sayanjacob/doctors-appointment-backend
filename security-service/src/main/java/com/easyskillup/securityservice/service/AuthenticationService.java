package com.easyskillup.securityservice.service;

import com.easyskillup.securityservice.controller.dto.AuthenticationRequest;
import com.easyskillup.securityservice.controller.dto.AuthenticationResponse;
import com.easyskillup.securityservice.controller.dto.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
