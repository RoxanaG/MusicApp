package com.example.android.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class playlistgorillaz extends AppCompatActivity {
    private ArrayList<Music> arrayList;
    private ListView playlist;
    private MusicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        ListView playlist = findViewById(R.id.playerList);
        ArrayList<Music> arrayList = new ArrayList<>();
        arrayList.add(new Music("Clint Eastwood", " Gorillaz", R.raw.clint));
        arrayList.add(new Music("Rock The House", "  Gorillaz", R.raw.rockthehouse));
        arrayList.add(new Music("19-2000", " Gorillaz", R.raw.song19_2000));
        arrayList.add(new Music("Starshine", " Gorillaz", R.raw.starshine));
        arrayList.add(new Music("Kids with Guns", "Demon Days", R.raw.kidswithguns));
        arrayList.add(new Music("Dirty Harry", "Demon Days", R.raw.dirtyharry));
        arrayList.add(new Music("Feel Good Inc.", "Demon Days", R.raw.feelgood));
        arrayList.add(new Music("White Flag", "Plastic Beach", R.raw.whiteflag));
        arrayList.add(new Music("Stylo", "Plastic Beach", R.raw.stylo));
        arrayList.add(new Music("Empire Ants", "Plastic Beach", R.raw.empireants));
        arrayList.add(new Music("Some Kind of Nature", "Plastic Beach", R.raw.somekind));
        arrayList.add(new Music("Re-Hash", "Gorillaz", R.raw.rehash));
        arrayList.add(new Music("5/4", "Gorillaz", R.raw.song5_4));

        adapter = new MusicAdapter(this, R.layout.playlist_item, arrayList);
        playlist.setAdapter(adapter);
    }
}