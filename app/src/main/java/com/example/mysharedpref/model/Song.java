package com.example.mysharedpref.model;

public class Song {

    public String title;
    public String artistName;

    public Song(String title) {
        this.title = title;
        this.artistName = "artist "+title;
    }

}
