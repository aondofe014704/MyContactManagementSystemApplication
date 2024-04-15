package org.contactManagementSystem.dtos.responses;

import lombok.Data;

@Data
public class CreateContactResponse {
    private String firstName;
    private String lastName;
    private String nickName;
    private String phoneNumber;
    private String emailAddress;
    private String notes;
    private String message;
}
