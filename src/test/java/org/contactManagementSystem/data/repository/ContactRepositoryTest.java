package org.contactManagementSystem.data.repository;

import org.contactManagementSystem.data.model.Contact;
import org.contactManagementSystem.dtos.requests.CreateContactRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ContactRepositoryTest {
    @Autowired
    ContactRepository contactRepository;
    @Test
    public void testToSaveAContactInTheRepository(){
        CreateContactRequest createContactRequest = new CreateContactRequest();
        Contact contact = new Contact();
        contact.setFirstName(createContactRequest.getFirstName());
        contact.setLastName(createContactRequest.getLastName());
        contact.setPhoneNumber(createContactRequest.getPhoneNumber());
        contact.setEmailAddress(createContactRequest.getEmailAddress());
        contact.setUserName(createContactRequest.getFirstName());
        contact.setNotes(createContactRequest.getNotes());
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());
    }
    @Test
    public  void testUpdateAnAlreadySavedContactInTheRepository(){
        CreateContactRequest createContactRequest = new CreateContactRequest();
        Contact contact = new Contact();
        contact.setFirstName(createContactRequest.getFirstName());
        contact.setLastName(createContactRequest.getLastName());
        contact.setPhoneNumber(createContactRequest.getPhoneNumber());
        contact.setEmailAddress(createContactRequest.getEmailAddress());
        contact.setUserName(createContactRequest.getFirstName());
        contact.setNotes(createContactRequest.getNotes());
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

    }
}