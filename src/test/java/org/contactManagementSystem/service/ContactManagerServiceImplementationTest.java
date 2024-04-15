package org.contactManagementSystem.service;
import org.contactManagementSystem.data.model.ContactManager;
import org.contactManagementSystem.data.repository.ContactManagerRepository;
import org.contactManagementSystem.dtos.requests.LogOutRequest;
import org.contactManagementSystem.dtos.requests.LoginRequest;
import org.contactManagementSystem.dtos.requests.RegistrationRequest;
import org.contactManagementSystem.dtos.responses.LoginResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContactManagerServiceImplementationTest {
    @Autowired
    private ContactManagerRepository contactManagerRepository;
    @Autowired
    private ContactManagerService contactManagerService;

//    @BeforeEach
//    public void collapseAll(){
//        contactManagerRepository.deleteAll();
//    }
    @Test
    public void testToRegisterAContactManagerInToTheRepository(){
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstName("Jack");
        registrationRequest.setLastName("Songu");
        registrationRequest.setPassword("password");
        registrationRequest.setUserName("username");
        contactManagerService.register(registrationRequest);
        assertEquals(1, contactManagerRepository.count());
    }
    @Test
    public void testToRegisterTwiceAContactManagerInToTheRepository(){
        RegistrationRequest registrationRequest = new RegistrationRequest();
        contactManagerRepository.deleteAll();
        registrationRequest.setFirstName("Jack");
        registrationRequest.setLastName("Songu");
        registrationRequest.setPassword("password");
        registrationRequest.setUserName("username");
        contactManagerService.register(registrationRequest);

        RegistrationRequest registrationRequestOne = new RegistrationRequest();
        registrationRequestOne.setFirstName("Mesh");
        registrationRequestOne.setLastName("Yaro");
        registrationRequestOne.setPassword("passwordOne");
        registrationRequestOne.setUserName("username1");
        contactManagerService.register(registrationRequestOne);
        assertEquals(2, contactManagerRepository.count());
    }
    @Test
    public void testToLogInAContactManagerInToTheRepository(){
        contactManagerRepository.deleteAll();
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstName("Cultist");
        registrationRequest.setLastName("Orwam");
        registrationRequest.setPassword("Kultist12");
        registrationRequest.setUserName("Josephine10");
        contactManagerService.register(registrationRequest);
        assertEquals(1, contactManagerRepository.count());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword(registrationRequest.getPassword());
        loginRequest.setUserName("Josephine10");
        LoginResponse response = contactManagerService.login(loginRequest);
        ContactManager contactManager = contactManagerService.findByUserName(registrationRequest.getUserName());
        contactManagerService.login(loginRequest);
        assertTrue(contactManager.isLoggedIn());
    }
    @Test
    public void testToLogInTwoContactManagersAndLogOutOne(){
        contactManagerRepository.deleteAll();
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstName("firstname");
        registrationRequest.setLastName("lastname");
        registrationRequest.setPassword("password");
        registrationRequest.setUserName("username");
        contactManagerService.register(registrationRequest);
        RegistrationRequest registrationRequest1 = new RegistrationRequest();
        registrationRequest1.setFirstName("firstname1");
        registrationRequest1.setLastName("lastname2");
        registrationRequest1.setPassword("passwordOne");
        registrationRequest1.setUserName("username1");
        contactManagerService.register(registrationRequest1);
        assertEquals(2, contactManagerRepository.count());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName(registrationRequest.getUserName());
        loginRequest.setPassword(registrationRequest.getPassword());
        contactManagerService.login(loginRequest);
        ContactManager contactManager = contactManagerService.findByUserName(registrationRequest.getUserName());
        assertTrue(contactManager.isLoggedIn());
        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest1.setPassword(registrationRequest.getPassword());
        loginRequest1.setUserName(registrationRequest.getUserName());
        contactManagerService.login(loginRequest1);
        ContactManager contactManager1 = contactManagerService.findByUserName(registrationRequest.getUserName());
        assertTrue(contactManager1.isLoggedIn());
        LogOutRequest logOutRequest = new LogOutRequest();
        logOutRequest.setUserName(registrationRequest.getUserName());
        contactManagerService.logOut(logOutRequest);
        contactManager = contactManagerRepository.findByUserName("username");
        assertFalse(contactManager.isLoggedIn());
    }
    @Test
    public void testToLogOut(){
        contactManagerRepository.deleteAll();
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstName("King");
        registrationRequest.setLastName("Perry");
        registrationRequest.setPassword("password");
        registrationRequest.setUserName("PerryWizzy");
        contactManagerService.register(registrationRequest);
        assertEquals(1, contactManagerRepository.count());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword(registrationRequest.getPassword());
        loginRequest.setUserName(registrationRequest.getUserName());
        contactManagerService.login(loginRequest);
        ContactManager contactManager = contactManagerService.findByUserName(registrationRequest.getUserName());
        assertTrue(contactManager.isLoggedIn());

        LogOutRequest logOutRequest = new LogOutRequest();
        logOutRequest.setUserName(registrationRequest.getUserName());
        logOutRequest.setMessage(logOutRequest.getMessage());
        contactManagerService.logOut(logOutRequest);
        ContactManager contactManager1 = contactManagerRepository.findByUserName(registrationRequest.getUserName());
        assertFalse(contactManager1.isLoggedIn());
    }

}