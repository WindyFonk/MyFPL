package com.example.myfpl.models;

import java.util.Date;

public class NewsModel {
    private String _description,image,time;

    public NewsModel(String _description, String image, String time) {
        this._description = _description;
        this.image = image;
        this.time = time;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}