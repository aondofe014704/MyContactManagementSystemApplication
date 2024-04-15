package org.contactManagementSystem.service;

import org.contactManagementSystem.data.model.Contact;
import org.contactManagementSystem.data.model.ContactManager;
import org.contactManagementSystem.dtos.requests.CreateContactRequest;
import org.contactManagementSystem.dtos.requests.DeleteContactRequest;
import org.contactManagementSystem.dtos.responses.CreateContactResponse;
import org.contactManagementSystem.dtos.responses.DeleteContactResponse;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {

    CreateContactResponse createContact(CreateContactRequest createContactRequest);

        DeleteContactResponse deleteContact(DeleteContactRequest deleteContactRequest);

        Contact findContactBy(String firstname);
}
