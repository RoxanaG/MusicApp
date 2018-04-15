package com.example.android.musicapp;

public class Music {
    private String name;
    private String album;
    private int song;

    public Music(String name, String album, int song) {
        this.name = name;
        this.album = album;
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}

