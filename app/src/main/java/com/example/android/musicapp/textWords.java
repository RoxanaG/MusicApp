

/**
 * Created by Ursu on 20/03/2018.
 */

package com.example.android.musicapp;



public class textWords {
    private String mSong;

    /** Miwok translation for the word */
    private String mAlbum;

    public textWords(String Song, String Album) {
        mSong = Song;
        mAlbum = Album;
    }

    /**
     * Get the default translation of the word.
     */
    public String getSong() {
        return mSong;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getAlbum() {
        return mAlbum;
    }



}
