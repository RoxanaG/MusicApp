package com.example.android.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.ListView;

import java.util.ArrayList;

public class playlistnina extends AppCompatActivity {
    private ArrayList<Music> arrayList;
    private ListView playlist;
    private MusicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        ListView playlist = findViewById(R.id.playerList);
        ArrayList<Music> arrayList = new ArrayList<>();
        arrayList.add(new Music("I Put A Spell On You", " Be Free The Nina Simone Story", R.raw.putaspell));
        arrayList.add(new Music("Feeling Good", "Compact Jazz: Nina Simone", R.raw.feelinggood));
        arrayList.add(new Music("Central Park Blues ", "Little Girl Blue", R.raw.centralpark));
        arrayList.add(new Music("Here Comes the Sun", "Here Comes the Sun", R.raw.herecomesthesun));
        arrayList.add(new Music("Sinnerman", "The Best Of Nina Simone ", R.raw.sinnerman));
        arrayList.add(new Music("My Way", "Here Comes the Sun", R.raw.myway));
        arrayList.add(new Music("In The Dark", "Nina Simone Sings the Blues", R.raw.inthedark));
        arrayList.add(new Music("Since I Fell for You", "Nina Simone Sings the Blues", R.raw.ifellforyou));
        arrayList.add(new Music("The House of the Rising Sun", "Nina Simone Sings the Blues", R.raw.houseofrising));
        arrayList.add(new Music("My Man's Gone Now", "Nina Simone Sings the Blues", R.raw.myman));
        arrayList.add(new Music("Ain't Got No, I Got Life", "'Nuff Said!", R.raw.igotno));
        arrayList.add(new Music("In the Morning", "'Nuff Said!", R.raw.inthemorning));
        arrayList.add(new Music("Peace of Mind", "'Nuff Said!", R.raw.peaceofmind));

        adapter = new MusicAdapter(this, R.layout.playlist_item, arrayList);
        playlist.setAdapter(adapter);
    }
}