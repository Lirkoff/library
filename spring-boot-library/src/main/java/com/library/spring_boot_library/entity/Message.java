package com.library.spring_boot_library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "title")
    private String title;

    @Column(name = "question")
    private String question;

    @Column(name = "admin_email")
    private String adminEmail;

    @Column
    private String response;

    @Column(name = "closed")
    private boolean closed;


    public Message(){}

    public Message(String title, String question) {
        this.title = title;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Message setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public Message setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Message setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public Message setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public Message setResponse(String response) {
        this.response = response;
        return this;
    }

    public boolean isClosed() {
        return closed;
    }

    public Message setClosed(boolean closed) {
        this.closed = closed;
        return this;
    }
}
