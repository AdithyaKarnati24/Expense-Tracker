package com.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String date;
    private String time;
    private String description;
    private String price;
    @ManyToOne
    private User user;

    public Expense( String title, String date, String time, String description, String price, User user) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.description = description;
        this.price = price;
        this.user = user;
    }

    public Expense() {
    }



}
