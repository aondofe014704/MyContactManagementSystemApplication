package org.contactManagementSystem.dtos.responses;

import lombok.Data;

@Data
public class UpdateContactResponse {
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String emailAddress;
    private String notes;
    private String message;
}
