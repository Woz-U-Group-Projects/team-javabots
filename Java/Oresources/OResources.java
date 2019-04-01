package com.props.oresources;

import javax.persistence.*;
import java.time.LocalDateTime;



@Entity
@Table(name="oresources")
public class OResources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String email;
    private String zipCode;
    private String owner;
    private String password;
    private String reEnterPassword;
    private LocalDateTime timeStamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReEnterPassword() {
        return reEnterPassword;
    }

    public void setReEnterPassword(String reEnterPassword) {
        this.reEnterPassword = reEnterPassword;
    }
    
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}