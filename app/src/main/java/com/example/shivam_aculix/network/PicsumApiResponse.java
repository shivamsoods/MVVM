package com.example.shivam_aculix.network;

import com.example.shivam_aculix.models.MainImageModel;

import java.util.List;

public class PicsumApiResponse {
    private List<PicsumApiResponse> imageList;
    private int id;
    private String author;
    private int width;
    private int height;
    private String url;
    private String download_url;
    private boolean has_more;

    public PicsumApiResponse(List<PicsumApiResponse> imageList, int id, String author, int width, int height, String url, String download_url, boolean has_more) {
        this.imageList = imageList;
        this.id = id;
        this.author = author;
        this.width = width;
        this.height = height;
        this.url = url;
        this.download_url = download_url;
        this.has_more = has_more;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public List<PicsumApiResponse> getImageList() {
        return imageList;
    }

    public void setImageList(List<PicsumApiResponse> imageList) {
        this.imageList = imageList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
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
