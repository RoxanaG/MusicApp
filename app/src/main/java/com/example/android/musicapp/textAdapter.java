package com.example.android.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class textAdapter extends ArrayAdapter<textWords> {

        public textAdapter(Context context, ArrayList<textWords> words) {
        super(context, 0, words);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.playlist_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        textWords currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView textSong = (TextView) listItemView.findViewById(R.id.textName);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        textSong.setText(currentWord.getSong());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView textAlbum = (TextView) listItemView.findViewById(R.id.textAlbum);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        textAlbum.setText(currentWord.getAlbum());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListVie


        return listItemView;

    }
}
