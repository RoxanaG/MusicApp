package com.example.android.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class playlistgorillaz  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist );

        // Create a list of words
        ArrayList<textWords> words = new ArrayList<textWords>();
        words.add(new textWords("Clint Eastwood", " Gorillaz"));
        words.add(new textWords("Rock The House", "  Gorillaz"));
        words.add(new textWords("19-2000", " Gorillaz"));
        words.add(new textWords("Starshine", " Gorillaz"));
        words.add(new textWords("Kids with Guns", "Demon Days"));
        words.add(new textWords("Dirty Harry", "Demon Days"));
        words.add(new textWords("Feel Good Inc.", "Demon Days"));
        words.add(new textWords("White Flag", "Plastic Beach"));
        words.add(new textWords("Stylo", "Plastic Beach"));
        words.add(new textWords("Empire Ants", "Plastic Beach"));
        words.add(new textWords("Some Kind of Nature", "Plastic Beach"));
        words.add(new textWords("Re-Hash", "Gorillaz"));
        words.add(new textWords("5/4", "Gorillaz"));

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

