package com.example.suivi_transaction.services.auth;

import com.example.suivi_transaction.dto.AddRequest;
import com.example.suivi_transaction.dto.SignupRequest;
import com.example.suivi_transaction.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);
}
