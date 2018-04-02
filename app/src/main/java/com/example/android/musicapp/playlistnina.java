package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class playlistnina extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist );

        ArrayList<textWords> words = new ArrayList<textWords>();
        words.add(new textWords("I Put A Spell On You"," To Be Free The Nina Simone Story"));
        words.add(new textWords("Feeling Good","Compact Jazz: Nina Simone"));
        words.add(new textWords("Central Park Blues ","Little Girl Blue"));
        words.add(new textWords("Here Comes the Sun","Here Comes the Sun"));
        words.add(new textWords("Sinnerman","The Best Of Nina Simone "));
         words.add(new textWords("My Way","Here Comes the Sun"));
        words.add(new textWords("In The Dark","Nina Simone Sings the Blues"));
        words.add(new textWords("Since I Fell for You","Nina Simone Sings the Blues"));
        words.add(new textWords("The House of the Rising Sun","Nina Simone Sings the Blues"));
        words.add(new textWords("My Man's Gone Now","Nina Simone Sings the Blues"));
        words.add(new textWords("Ain't Got No, I Got Life","'Nuff Said!"));
        words.add(new textWords("In the Morning","'Nuff Said!"));
        words.add(new textWords("Peace of Mind","'Nuff Said!"));
        textAdapter adapter = new textAdapter(this, words);
        ListView playlist = (ListView) findViewById(R.id.playerList);
        playlist.setAdapter(adapter);



    playlist.setOnItemClickListener(this);


    }
public int[] resID = {
            R.raw.putaspell,R.raw.feelinggood,R.raw.centralpark,R.raw.herecomesthesun,R.raw.sinnerman,R.raw.myway,R.raw.inthedark,R.raw.ifellforyou,R.raw.houseofrising,R.raw.myman,R.raw.igotno,R.raw.inthemorning,R.raw.peaceofmind
};

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(playlistnina.this,mediaPlayer.class);
        Intent  song = i.putExtra("Song",resID[position]);
        Intent  song_name=i.putExtra("SongName",getText(position));
        startActivity(i);
    }
        }



