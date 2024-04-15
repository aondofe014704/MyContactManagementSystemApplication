package org.contactManagementSystem.service;

import org.contactManagementSystem.data.model.Contact;
import org.contactManagementSystem.data.model.ContactManager;
import org.contactManagementSystem.data.repository.ContactManagerRepository;
import org.contactManagementSystem.data.repository.ContactRepository;
import org.contactManagementSystem.dtos.requests.CreateContactRequest;
import org.contactManagementSystem.dtos.requests.DeleteContactRequest;
import org.contactManagementSystem.dtos.responses.CreateContactResponse;
import org.contactManagementSystem.dtos.responses.DeleteContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImplementation implements org.contactManagementSystem.service.ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ContactManagerService contactManagerService;

    @Autowired
    ContactManagerRepository contactManagerRepository;

    @Override
    public CreateContactResponse createContact(CreateContactRequest createContactRequest) {
        Contact contact = new Contact();
        contact.setFirstName(createContactRequest.getFirstName());
        contact.setLastName(createContactRequest.getLastName());
        contact.setEmailAddress(createContactRequest.getEmailAddress());
        contact.setNotes(createContactRequest.getNotes());
        contact.setUserName(createContactRequest.getUsername());
        contact.setPhoneNumber(createContactRequest.getPhoneNumber());
        contactRepository.save(contact);
        ContactManager contactManager = contactManagerService.findByUserName(createContactRequest.getUsername());
        List<Contact> contactList = contactManager.getListOfContact();
        contactList.add(contact);
        contactManager.setListOfContact(contactList);
        contactManagerRepository.save(contactManager);
        CreateContactResponse createContactResponse = new CreateContactResponse();
        createContactResponse.setMessage("Contact Saved Successfully");
        return new CreateContactResponse();
    }


    @Override
    public DeleteContactResponse deleteContact(DeleteContactRequest deleteContactRequest) {
        ContactManager contactManager = contactManagerService.findByUserName(deleteContactRequest.getUserName());
        Contact contact = findContactBy(deleteContactRequest.getFirstName());
        contactRepository.delete(contact);
        List<Contact> contactList = contactManager.getListOfContact();
        contactList.remove(contact);
        contactManager.setListOfContact(contactList);
        contactManagerRepository.save(contactManager);
        DeleteContactResponse response = new DeleteContactResponse();
        response.setMessage("Contact Successfully Deleted");
        return response;
    }

    @Override
    public Contact findContactBy(String firstname) {
        for (Contact contact : contactRepository.findAll()){
            if (contact.getFirstName().equals(firstname)) return contact;
        }
        return new Contact();
    }
}
