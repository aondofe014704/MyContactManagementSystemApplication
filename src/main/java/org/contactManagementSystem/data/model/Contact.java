package org.contactManagementSystem.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Contact")
public class Contact {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String emailAddress;
    private String notes;

}
