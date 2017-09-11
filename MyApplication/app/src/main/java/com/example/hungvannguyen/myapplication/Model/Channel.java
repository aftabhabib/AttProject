package com.example.hungvannguyen.myapplication.Model;

/**
 * Created by HungVanNguyen on 9/11/2017.
 */

public class Channel {
    private  int img;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Channel() {
    }

    public Channel(int img, String url) {
        this.img = img;
        this.url = url;
    }

    public Channel(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
