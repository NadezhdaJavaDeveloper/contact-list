package org.example.contactList.repository;

import lombok.RequiredArgsConstructor;
import org.example.contactList.Contact;
import org.example.contactList.exception.ContactNotFoundException;
import org.example.contactList.repository.mapper.ContactRowMapper;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ContactRepositoryImpl implements ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Contact> findAll() {
        String sql = "SELECT * FROM contact_list.contacts";
        return jdbcTemplate.query(sql, new ContactRowMapper());
    }

    @Override
    public Optional<Contact> findById(Long id) {
        String sql = "SELECT * FROM contact_list.contacts WHERE id=?";
        Contact contact = DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, //запрос
                        new ArgumentPreparedStatementSetter(new Object[]{id}),
                        new RowMapperResultSetExtractor<>(new ContactRowMapper(), 1)
                )
        );
        return Optional.ofNullable(contact);
    }

    @Override
    public Contact save(Contact contact) {
        contact.setId(System.currentTimeMillis());
        String sql = "INSERT INTO contact_list.contacts (id, first_name, last_name, email, phone) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, contact.getId(), contact.getFirstName(),
                contact.getLastName(), contact.getEmail(), contact.getPhone());

        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        Contact existedContact = findById(contact.getId()).orElse(null);
        if (existedContact != null) {
            String sql = "UPDATE contact_list.contacts SET first_name=?, last_name=?, email=?, phone=? WHERE id=?";
            jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(),
                    contact.getEmail(), contact.getPhone(), contact.getId());
            return contact;
        }
        throw new ContactNotFoundException("Contact for update not found ID: " + contact.getId());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM contact_list.contacts WHERE id=?";
        jdbcTemplate.update(sql, id);

    }
}
