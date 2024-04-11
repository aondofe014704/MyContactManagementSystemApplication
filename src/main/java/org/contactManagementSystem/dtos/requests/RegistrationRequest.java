package org.contactManagementSystem.dtos;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String password;
    public String message;
    }
