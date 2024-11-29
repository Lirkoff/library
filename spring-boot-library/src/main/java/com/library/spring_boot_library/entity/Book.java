package com.library.spring_boot_library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "copies")
    private int copies;

    @Column(name = "copies_available")
    private int copiesAvailable;

    @Column(name = "category")
    private String category;

    @Column(name = "img")
    private String img;

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getCopies() {
        return copies;
    }

    public Book setCopies(int copies) {
        this.copies = copies;
        return this;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public Book setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Book setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getImg() {
        return img;
    }

    public Book setImg(String img) {
        this.img = img;
        return this;
    }
}
