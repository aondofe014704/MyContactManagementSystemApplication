package org.contactManagementSystem.dtos.requests;

import lombok.Data;

@Data
public class CreateContactRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String emailAddress;
    private String notes;
}
