package org.contactManagementSystem.data.repository;

import org.contactManagementSystem.data.model.ContactManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactManagerRepository extends MongoRepository<ContactManager, String> {
    ContactManager findByUserName(String userName);
    

}
