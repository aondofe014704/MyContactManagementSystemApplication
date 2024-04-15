package org.contactManagementSystem.dtos.requests;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    }
