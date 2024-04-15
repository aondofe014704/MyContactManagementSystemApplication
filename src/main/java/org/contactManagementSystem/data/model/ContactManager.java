package org.contactManagementSystem.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("ContactManager")
public class ContactManager {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean isLoggedIn;
   @DBRef
    private List<Contact> listOfContact = new ArrayList<>();
}
