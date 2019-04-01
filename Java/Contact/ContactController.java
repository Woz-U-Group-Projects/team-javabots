package com.props.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    ContactRepository dao;

    @GetMapping("/contact")
    public List<Contact> getContacts() {
        List<Contact> foundContacts = dao.findAll();
        return foundContacts;
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable(value="id") String id) {
    	Contact foundContact = dao.findById(id).orElse(null);

        if(foundContact == null) {
            return ResponseEntity.notFound().header("Contact","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundContact);
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> postContact(@RequestBody Contact contact) {

        // saving to DB using instance of the repo interface
    	Contact createdContact = dao.save(contact);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdContact);
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<Contact> deleteContact(@PathVariable(value="id") String id) {
    	Contact foundContact = dao.findById(id).orElse(null);

        if(foundContact == null) {
            return ResponseEntity.notFound().header("Contact","Nothing found with that id").build();
        }else {
            dao.delete(foundContact);
        }
        return ResponseEntity.ok().build();
    }
}