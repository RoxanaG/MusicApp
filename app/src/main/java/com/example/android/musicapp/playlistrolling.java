package com.example.android.musicapp;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class playlistrolling extends AppCompatActivity {
    private ArrayList<Music> arrayList;
    private ListView playlist;
    private MusicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        ListView playlist = (ListView) findViewById(R.id.playerList);
        ArrayList<Music> arrayList = new ArrayList<Music>();
        arrayList.add(new Music("Gimme Shelter", "Let It Bleed", R.raw.gimmieshelter));
        arrayList.add(new Music("Monkey Man", "Let It Bleed", R.raw.monkeyman));
        arrayList.add(new Music("Let It Bleed", "Let It Bleed", R.raw.letitbleed));
        arrayList.add(new Music("Love In Vain", "Let It Bleed", R.raw.loveinvain));
        arrayList.add(new Music("Satisfaction", "Out Of Our Heads", R.raw.satisfaction));
        arrayList.add(new Music("Angie ", "  Goats Head Soup", R.raw.angie));
        arrayList.add(new Music("I'm Free", "Decembers Children", R.raw.free));
        arrayList.add(new Music("Time Is on My Side", "12 x 5", R.raw.timeisonmyside));
        arrayList.add(new Music("It's All Over Now", " 12 x 5", R.raw.itsallover));
        arrayList.add(new Music("Paint It Black", " Aftermaths", R.raw.paintitblack));
        arrayList.add(new Music("Brown Sugar", "Sticky Fingers", R.raw.brownsugar));
        arrayList.add(new Music("Street Fighting Man", "Beggars Banquet", R.raw.streetfighting));
        arrayList.add(new Music("Sympathy for the Devil", " Beggars Banquet", R.raw.symphaty));

        adapter = new MusicAdapter(this, R.layout.playlist_item, arrayList);
        playlist.setAdapter(adapter);
    }
}

