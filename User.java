package com.entity;

import lombok.Data;

import javax.persistence.*;
//@Cacheable
//@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String about;

    public User() {

    }
    public User(String fullName, String email, String password, String about) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.about = about;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}