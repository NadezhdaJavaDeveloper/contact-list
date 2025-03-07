package org.example.contactList.service;

import lombok.RequiredArgsConstructor;
import org.example.contactList.Contact;
import org.example.contactList.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactListServiceImpl implements ContactListService {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.update(contact);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);

    }
}
