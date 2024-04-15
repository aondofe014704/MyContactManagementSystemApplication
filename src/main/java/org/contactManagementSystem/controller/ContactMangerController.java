package org.contactManagementSystem.controller;
import org.contactManagementSystem.dtos.requests.DeleteContactRequest;
import org.contactManagementSystem.dtos.requests.LogOutRequest;
import org.contactManagementSystem.dtos.requests.LoginRequest;
import org.contactManagementSystem.dtos.requests.RegistrationRequest;
import org.contactManagementSystem.dtos.responses.*;
import org.contactManagementSystem.exceptions.ContactManagerExceptions;
import org.contactManagementSystem.service.ContactManagerService;
import org.contactManagementSystem.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1")
public class ContactMangerController {
    @Autowired
    private ContactManagerService contactManagerService;
    @Autowired
    ContactService contactService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest) {
        try {
            RegistrationResponse registrationResponse = contactManagerService.register(registrationRequest);
            return new ResponseEntity<>(new APIResponse(true, registrationResponse), CREATED);
        } catch (ContactManagerExceptions r) {
            return new ResponseEntity<>(new APIResponse(false, r.getMessage()), BAD_REQUEST);

        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse loginResponse = contactManagerService.login(loginRequest);
            return new ResponseEntity<>(new APIResponse(true, loginResponse), CREATED);
        } catch (ContactManagerExceptions r) {
            return new ResponseEntity<>(new APIResponse(false, r.getMessage()), BAD_REQUEST);

        }
    }
    @PostMapping("/deleteContact")
    public ResponseEntity<?> deleteContact(@RequestBody DeleteContactRequest deleteContactRequest) {
        try {
            DeleteContactResponse deleteContactResponse = contactService.deleteContact(deleteContactRequest);
            return new ResponseEntity<>(new APIResponse(true, deleteContactResponse), CREATED);
        } catch (ContactManagerExceptions r) {
            return new ResponseEntity<>(new APIResponse(false, r.getMessage()), BAD_REQUEST);

        }
    }
    @PostMapping("/logOut")
    public ResponseEntity<?> logOut(@RequestBody LogOutRequest logOutRequest) {
        try {
            LogOutResponse logOutResponse = contactManagerService.logOut(logOutRequest);
            return new ResponseEntity<>(new APIResponse(true, logOutResponse), CREATED);
        } catch (ContactManagerExceptions r) {
            return new ResponseEntity<>(new APIResponse(false, r.getMessage()), BAD_REQUEST);

        }
    }

}
