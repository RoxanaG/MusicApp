package com.example.android.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class  playlistbob extends AppCompatActivity {

    private ArrayList<Music> arrayList;
    private ListView playlist;
private MusicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        ListView playlist =  findViewById(R.id.playerList);
        ArrayList<Music> arrayList = new ArrayList<>();
        arrayList.add(new Music("Like a rolling stone", "Highway 61 Revisited", R.raw.likearollingstone));
        arrayList.add(new Music("Blowin in The Wind", "Freewheelin' Bob Dylan", R.raw.blowing));
        arrayList.add(new Music("A Hard Rain's A-Gonna Fall", "Freewheelin' Bob Dylan", R.raw.hardrain));
        arrayList.add(new Music("Don't Think Twice It's All Right", "Freewheelin' Bob Dylan", R.raw.dontthink));
        arrayList.add(new Music("Masters of War", "Freewheelin' Bob Dylan", R.raw.masters));
        arrayList.add(new Music("Tangled Up in Blue", "Blood on the Tracks", R.raw.tangledup));
        arrayList.add(new Music("Shelter From the Storm", "Blood on the Tracks", R.raw.shelter));
        arrayList.add(new Music("Idiot Wind", "Blood on the Tracks", R.raw.idiotwind));
        arrayList.add(new Music("Visions of Johanna", "Blonde on Blonde", R.raw.visions));
        arrayList.add(new Music("Rainy Day Women 12 & 35", "Blonde on Blonde", R.raw.rainyday));
        arrayList.add(new Music("It's Alright, Ma", "Bringing It All Back Home", R.raw.itsalright));
        arrayList.add(new Music("Subterranean Homesick Blues", "Bringing It All Back Home", R.raw.subterranean));
        arrayList.add(new Music("Not Dark Yet", "Time Out of Mind", R.raw.notdarkyet));

        adapter = new MusicAdapter(this,R.layout.playlist_item,arrayList);
        playlist.setAdapter(adapter);

    }}