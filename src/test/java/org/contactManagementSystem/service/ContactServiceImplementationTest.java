package org.contactManagementSystem.service;
import org.contactManagementSystem.data.repository.ContactRepository;
import org.contactManagementSystem.dtos.requests.CreateContactRequest;
import org.contactManagementSystem.dtos.requests.DeleteContactRequest;
import org.contactManagementSystem.dtos.requests.RegistrationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ContactServiceImplementationTest {
    @Autowired
    private ContactManagerService contactManagerService;

    @Autowired
    private ContactService contactService;
    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testToCreateContactInTheRepository() {
        contactRepository.deleteAll();
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstName("Cultist");
        registrationRequest.setLastName("Enter");
        registrationRequest.setPassword("password");
        registrationRequest.setUserName("X-Men");
        contactManagerService.register(registrationRequest);
        CreateContactRequest createContactRequest = new CreateContactRequest();
        createContactRequest.setFirstName("Cultist");
        createContactRequest.setLastName("Enter");
        createContactRequest.setUsername("X-Men");
        createContactRequest.setNotes("Cultist na real G");
        createContactRequest.setPhoneNumber("08133608698");
        createContactRequest.setEmailAddress("kultist12@gmail.com");
        contactService.createContact(createContactRequest);
        assertEquals(1, contactRepository.count());
    }

    @Test
    public void testToCreateTwoContactInTheRepository() {
        contactRepository.deleteAll();
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstName("kingPerry");
        registrationRequest.setLastName("Wizzy");
        registrationRequest.setPassword("password1");
        registrationRequest.setUserName("Max");
        contactManagerService.register(registrationRequest);

        CreateContactRequest createContactRequest1 = new CreateContactRequest();
        createContactRequest1.setFirstName("KingPerry");
        createContactRequest1.setLastName("Wizzy");
        createContactRequest1.setPhoneNumber("0806509890");
        createContactRequest1.setEmailAddress("MaryClark@gmail.com");
        createContactRequest1.setUsername("Max");
        createContactRequest1.setNotes("Black Diamond");
        contactService.createContact(createContactRequest1);
        assertEquals(1, contactRepository.count());
    }
    @Test
    public void testToCreateTwoContactInTheRepositoryAndDeleteOne(){
        contactRepository.deleteAll();
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstName("Jack");
        registrationRequest.setLastName("Songu");
        registrationRequest.setPassword("password");
        registrationRequest.setUserName("Panda");
        contactManagerService.register(registrationRequest);
        RegistrationRequest registrationRequest2 = new RegistrationRequest();
        registrationRequest2.setFirstName("Jack");
        registrationRequest2.setLastName("Songu");
        registrationRequest2.setPassword("password");
        registrationRequest2.setUserName("Lord-X");
        contactManagerService.register(registrationRequest2);
        CreateContactRequest createContactRequest = new CreateContactRequest();
        createContactRequest.setFirstName("Mary");
        createContactRequest.setLastName("Clark");
        createContactRequest.setPhoneNumber("08065099017");
        createContactRequest.setEmailAddress("PandaWizzy@gmail.com");
        createContactRequest.setUsername("Lord-X");
        createContactRequest.setNotes("QueenJack");
        contactService.createContact(createContactRequest);
        CreateContactRequest createContactRequest1 = new CreateContactRequest();
        createContactRequest1.setFirstName("kingPerry");
        createContactRequest1.setLastName("Wizzy");
        createContactRequest1.setPhoneNumber("08065099019");
        createContactRequest1.setEmailAddress("KingPerry@gmail.com");
        createContactRequest1.setUsername("Lord-X");
        createContactRequest1.setNotes("G");
        contactService.createContact(createContactRequest1);
        assertEquals(2, contactRepository.count());
        assertEquals(2, contactManagerService.findByUserName("Lord-X").getListOfContact().size());
        DeleteContactRequest deleteContactRequest = new DeleteContactRequest();
        deleteContactRequest.setUserName("Lord-X");
        deleteContactRequest.setFirstName("Mary");
        contactService.deleteContact(deleteContactRequest);
        assertEquals(1, contactRepository.count());
        assertEquals(1, contactManagerService.findByUserName("Lord-X").getListOfContact().size());
    }
}