package com.props.contact;

import org.springframework.data.jpa.repository.JpaRepository;

import com.props.contact.Contact;

public interface ContactRepository extends JpaRepository<Contact, String> {

}