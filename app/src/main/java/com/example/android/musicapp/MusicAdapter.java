package com.example.android.musicapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList arrayList;
    private MediaPlayer mediaPlayer;
    private boolean flag = true;

    public MusicAdapter(Context context, int layout, ArrayList<Music> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class Holder{
        TextView textName,textAlbum;
        ImageView play, stop;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        if (convertView == null){
            holder = new Holder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout,null);
            holder.textName = (TextView) convertView.findViewById(R.id.textName);
            holder.textAlbum = (TextView) convertView.findViewById(R.id.textAlbum);
            holder.play = convertView.findViewById(R.id.play);
            holder.stop = convertView.findViewById(R.id.stop);

            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();

        }
        final Music music = (Music) arrayList.get(position);
        holder.textName.setText(music.getName());
        holder.textAlbum.setText(music.getAlbum());
        mediaPlayer = new MediaPlayer();

        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (flag){
   flag = false;
    mediaPlayer = MediaPlayer.create(context, music.getSong());
            mediaPlayer.start();
            currentPosition = position;
        }else {
            if (currentPosition != position) {
                mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(context, music.getSong());
                mediaPlayer.start();
        currentPosition = position;
    } else {
   if (mediaPlayer.isPlaying()) {
        mediaPlayer.pause();
        holder.play.setImageResource(R.drawable.ic_play);

    } else {
        mediaPlayer.start();
        holder.play.setImageResource(R.drawable.pause);
    }
}
            }
        }});

        holder.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag = true;
                }
                holder.play.setImageResource(R.drawable.ic_play);
            }
        });
        return convertView;

    }
}
