package com.example.shivam_aculix.network;

import com.example.shivam_aculix.models.MainImageModel;

import java.util.List;

public class PicsumApiResponse {
    private List<MainImageModel> imageList;
    private int id;
    private String author;
    private int width;
    private int height;
    private String url;
    private String download_url;

    public List<MainImageModel> getImageList() {
        return imageList;
    }

    public void setImageList(List<MainImageModel> imageList) {
        this.imageList = imageList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PicsumApiResponse> getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }
}
