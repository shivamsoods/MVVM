package com.example.shivam_aculix.models;

public class MainImageModel {
    private String author;
    private String imageUrl;

    public MainImageModel(String author, String imageUrl) {
        this.author = author;
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
