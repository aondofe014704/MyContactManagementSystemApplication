package org.contactManagementSystem.dtos.responses;

import lombok.Data;

@Data
public class RegistrationResponse {
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String message;

}
