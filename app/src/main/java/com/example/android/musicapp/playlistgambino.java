package com.example.android.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;



public class playlistgambino  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist );

        // Create a list of words
        ArrayList<textWords> words = new ArrayList<textWords>();
        words.add(new textWords("Fire Fly", " Camp"));
        words.add(new textWords("Letter Home", "  Camp"));
        words.add(new textWords("You See Me", "Camp"));
        words.add(new textWords("The Library", "Because the Internet"));
        words.add(new textWords("Dial Up", "Because the Internet"));
        words.add(new textWords("Death by Numbers", "Because the Internet"));
        words.add(new textWords("Crawl", "Because the Internet"));
        words.add(new textWords("Me and Your Mama", "Awaken, My Love!"));
        words.add(new textWords("Boogieman", "Awaken, My Love!"));
        words.add(new textWords("Riot", "Awaken, My Love!"));
        words.add(new textWords("Redbone", "Awaken, My Love!"));
        words.add(new textWords("Baby Boy", "Awaken, My Love!"));
        words.add(new textWords("Stand Tall", "Awaken, My Love!"));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        textAdapter adapter = new textAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView playlist = (ListView) findViewById(R.id.playerList);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        playlist.setAdapter(adapter);
    }
}

