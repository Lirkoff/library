package com.library.spring_boot_library.requestModels;


public class AddBookRequest {
    private String title;

    private String author;

    private String description;

    private int copies;

    private String category;

    private String img;

    public String getTitle() {
        return title;
    }

    public AddBookRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public AddBookRequest setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddBookRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getCopies() {
        return copies;
    }

    public AddBookRequest setCopies(int copies) {
        this.copies = copies;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public AddBookRequest setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getImg() {
        return img;
    }

    public AddBookRequest setImg(String img) {
        this.img = img;
        return this;
    }
}
