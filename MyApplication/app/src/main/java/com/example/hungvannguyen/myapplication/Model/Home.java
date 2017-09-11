package com.example.hungvannguyen.myapplication.Model;

import java.util.List;

/**
 * Created by HungVanNguyen on 9/11/2017.
 */

public class Home {
    private String name;
    private List<Channel> channels;

    public Home() {
    }

    public Home(String name, List<Channel> channels) {
        this.name = name;
        this.channels = channels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }
}
