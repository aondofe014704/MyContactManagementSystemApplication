package org.contactManagementSystem.dtos.responses;

import lombok.Data;

@Data
public class LoginResponse {
    private String userName;
    private String password;
    private String message;
}
