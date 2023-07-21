package com.example.myfpl.models;

import java.util.Date;

public class NewsModel {
  private String Id,Title,Time,Author;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public NewsModel(String id, String title, String time, String author) {
        Id = id;
        Title = title;
        Time = time;
        Author = author;
    }
}