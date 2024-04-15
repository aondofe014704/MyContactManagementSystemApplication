package org.contactManagementSystem.service;

import org.contactManagementSystem.data.model.ContactManager;
import org.contactManagementSystem.data.repository.ContactManagerRepository;
import org.contactManagementSystem.dtos.requests.LogOutRequest;
import org.contactManagementSystem.dtos.requests.LoginRequest;
import org.contactManagementSystem.dtos.requests.RegistrationRequest;
import org.contactManagementSystem.dtos.responses.LogOutResponse;
import org.contactManagementSystem.dtos.responses.LoginResponse;
import org.contactManagementSystem.dtos.responses.RegistrationResponse;
import org.contactManagementSystem.exceptions.InvalidPasswordException;
import org.contactManagementSystem.exceptions.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactManagerServiceImplementation implements ContactManagerService{
    @Autowired
    private ContactManagerRepository contactManagerRepository;
    @Override
    public RegistrationResponse register(RegistrationRequest registrationRequest) {
        ContactManager contactManager = new ContactManager();
        contactManager.setFirstName(registrationRequest.getFirstName());
        contactManager.setLastName(registrationRequest.getLastName());
        contactManager.setPassword(registrationRequest.getPassword());
        contactManager.setUserName(registrationRequest.getUserName());
        contactManagerRepository.save(contactManager);

        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setFirstName(registrationRequest.getFirstName());
        registrationResponse.setLastName(registrationRequest.getLastName());
        registrationResponse.setPassword(registrationRequest.getPassword());
        registrationResponse.setUsername(registrationRequest.getUserName());
        registrationResponse.setMessage("Successfully Registered");
        return registrationResponse;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        ContactManager contactManager = findByUserName(loginRequest.getUserName());
        if (!(contactManager.getPassword().equals(loginRequest.getPassword())))
           throw new InvalidPasswordException("Password Is Incorrect");
        contactManager.setUserName(loginRequest.getUserName());
        contactManager.setPassword(loginRequest.getPassword());
        contactManager.setLoggedIn(true);
        contactManagerRepository.save(contactManager);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserName(loginRequest.getUserName());
        loginResponse.setPassword(loginRequest.getPassword());
        loginResponse.setMessage("Successfully logged In");
        return loginResponse;
    }
    @Override
    public ContactManager findByUserName(String userName) {
        ContactManager contactManager = contactManagerRepository.findByUserName(userName);
        if(contactManager == null) {
            throw new UsernameNotFoundException("username does not exist");
        }
        return contactManager;
    }
    @Override
    public LogOutResponse logOut(LogOutRequest logOutRequest) {
        ContactManager contactManager = findByUserName(logOutRequest.getUserName());
        contactManager.setLoggedIn(false);
        contactManagerRepository.save(contactManager);

        LogOutResponse logOutResponse = new LogOutResponse();
        logOutResponse.setUserName(logOutRequest.getUserName());
        logOutResponse.setMessage("Successfully Log Out");
        return logOutResponse;
    }


}
