package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       gridView = findViewById(R.id.album_Gridview);
       gridView.setAdapter(new imageAdapter(this));
       gridView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() ==R.id.album_Gridview){
            switch (position){
                case 0:{
                    startActivity(new Intent(this, playlistbob.class));
                    break;
                }
                case 1:{
                    startActivity(new Intent(this, playlistnina.class));
                    break;
                }
                case 2:{
                    startActivity(new Intent(this, playlistrolling.class));
                    break;
                }
                case 3:{
                    startActivity(new Intent(this, playlistlp.class));
                    break;
                }
                case 4:{
                    startActivity(new Intent(this, playlistgorillaz.class));
                    break;
                }
                case 5:{
                    startActivity(new Intent(this, playlistgambino.class));
                    break;
                }
            }
        }

    }

}

