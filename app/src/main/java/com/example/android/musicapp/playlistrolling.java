package com.example.android.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;



public class playlistrolling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist );

        // Create a list of words
        ArrayList<textWords> words = new ArrayList<textWords>();
        words.add(new textWords("Gimme Shelter", "Let It Bleed"));
        words.add(new textWords("Monkey Man", "Let It Bleed"));
        words.add(new textWords("Let It Bleed", "Let It Bleed"));
        words.add(new textWords("Love In Vain", "Let It Bleed"));
        words.add(new textWords("Satisfaction", "Out Of Our Heads"));
        words.add(new textWords("The Spider and the Fly", " Out Of Our Heads"));
        words.add(new textWords("Good Times", "Out Of Our Heads"));
        words.add(new textWords("Time Is on My Side", "12 x 5"));
        words.add(new textWords("It's All Over Now", " 12 x 5"));
        words.add(new textWords("Wild Horses", "Sticky Fingers"));
        words.add(new textWords("Brown Sugar", "Sticky Fingers"));
        words.add(new textWords("My Obsession", "Between the Buttons"));
        words.add(new textWords("Connection", " Between the Buttons"));

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


