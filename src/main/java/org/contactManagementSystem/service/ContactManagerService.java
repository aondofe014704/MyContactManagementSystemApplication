package org.contactManagementSystem.service;

import org.contactManagementSystem.data.model.ContactManager;
import org.contactManagementSystem.dtos.requests.LogOutRequest;
import org.contactManagementSystem.dtos.requests.LoginRequest;
import org.contactManagementSystem.dtos.requests.RegistrationRequest;
import org.contactManagementSystem.dtos.responses.LogOutResponse;
import org.contactManagementSystem.dtos.responses.LoginResponse;
import org.contactManagementSystem.dtos.responses.RegistrationResponse;
import org.springframework.stereotype.Service;

@Service
public interface ContactManagerService {
    RegistrationResponse register(RegistrationRequest registrationRequest);

    LoginResponse login(LoginRequest loginRequest);

    ContactManager findByUserName(String userName);

    LogOutResponse logOut(LogOutRequest logOutRequest);

}
