package org.example.contactList.service;

import org.example.contactList.Contact;

import java.util.List;

public interface ContactListService {

    List<Contact> findAll();
    Contact findById(Long id);
    Contact save(Contact contact);
    Contact update(Contact contact);
    void deleteById(Long id);

}
