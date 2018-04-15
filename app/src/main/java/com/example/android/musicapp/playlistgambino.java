package com.example.android.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class playlistgambino extends AppCompatActivity {
    private ArrayList<Music> arrayList;
    private ListView playlist;
    private MusicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        ListView playlist = findViewById(R.id.playerList);
        ArrayList<Music> arrayList = new ArrayList<>();
        arrayList.add(new Music("Firefly", " Camp", R.raw.firefly));
        arrayList.add(new Music("Letter Home", "  Camp", R.raw.letterhome));
        arrayList.add(new Music("You See Me", "Camp", R.raw.youseeme));
        arrayList.add(new Music("Worldstar", "Because the Internet", R.raw.worldstar));
        arrayList.add(new Music("The Palisades Ft. Christian Rich ", "Because the Internet", R.raw.thepalisades));
        arrayList.add(new Music(" Heartbeat", "Because the Internet", R.raw.heartbeat));
        arrayList.add(new Music("Crawl", "Because the Internet", R.raw.crawl));
        arrayList.add(new Music("Me and Your Mama", "Awaken, My Love!", R.raw.meandyourmama));
        arrayList.add(new Music("Sweatpants", "Awaken, My Love!", R.raw.sweatpants));
        arrayList.add(new Music("Riot", "Awaken, My Love!", R.raw.riot));
        arrayList.add(new Music("Redbone", "Awaken, My Love!", R.raw.redbone));
        arrayList.add(new Music("Baby Boy", "Awaken, My Love!", R.raw.babyboy));
        arrayList.add(new Music("Stand Tall", "Awaken, My Love!", R.raw.standtall));

        adapter = new MusicAdapter(this, R.layout.playlist_item, arrayList);
        playlist.setAdapter(adapter);
    }
}
