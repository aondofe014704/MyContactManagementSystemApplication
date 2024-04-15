package org.contactManagementSystem.data.repository;

import org.contactManagementSystem.data.model.ContactManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContactManagerRepositoryTest {
    @Autowired
    private ContactManagerRepository contactManagerRepository;
    @Test
    public void testToSaveContactManagerInTheRepository(){
        ContactManager contactManager = new ContactManager();
        contactManager.setFirstName("Jack");
        contactManager.setLastName("Songu");
        contactManager.setPassword("password");
        contactManager.setListOfContact(new ArrayList<>());
        contactManagerRepository.save(contactManager);
        assertEquals(1, contactManagerRepository.count());
    }


}