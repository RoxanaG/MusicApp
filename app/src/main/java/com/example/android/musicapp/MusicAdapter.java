package com.example.android.musicapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
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
    private int currentPosition;
    private ArrayList arrayList;
    private MediaPlayer mediaPlayer;
    private boolean flag = true;
    private ImageView currentPlayingButton;

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

    private class Holder {
        TextView textName, textAlbum;
        ImageView play, stop;
    }


    @Override
    public View getView(final int pos, View convertView, final ViewGroup parent) {
        final Holder holder;
        final int position = pos;
        if (convertView == null) {
            holder = new Holder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            holder.textName = (TextView) convertView.findViewById(R.id.textName);
            holder.textAlbum = (TextView) convertView.findViewById(R.id.textAlbum);
            holder.play = convertView.findViewById(R.id.play);
            holder.stop = convertView.findViewById(R.id.stop);
            currentPlayingButton = holder.play;
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();

        }


        final Music music = (Music) arrayList.get(position);
        holder.textName.setText(music.getName());
        holder.textAlbum.setText(music.getAlbum());
        if (currentPlayingButton != null) {
            holder.play.setImageResource(R.drawable.ic_play);
            currentPlayingButton = holder.play;
        }
        holder.play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {

                    mediaPlayer = MediaPlayer.create(context, music.getSong());
                    mediaPlayer.start();
                    currentPosition = position;
                    holder.play.setImageResource(R.drawable.pause);
                    currentPlayingButton = holder.play;
                } else {
                    if (currentPosition != position) {

                        mediaPlayer.reset();
                        mediaPlayer.release();
                        currentPlayingButton.setImageResource(R.drawable.ic_play);
                        currentPlayingButton = holder.play;


                        mediaPlayer = MediaPlayer.create(context, music.getSong());
                        mediaPlayer.start();
                        holder.play.setImageResource(R.drawable.pause);
                        currentPosition = position;
                    } else {
                        if (mediaPlayer.isPlaying()) {
                            Log.v("Adapter", "mediaPlayer should be playing here" + mediaPlayer.isPlaying());
                            mediaPlayer.pause();
                            holder.play.setImageResource(R.drawable.ic_play);
                            Log.v("Adapter", "user clicked the same row and isPlaying");
                            Log.v("Adapter", "" + currentPosition);
                            Log.v("Adapter", "mediaPlayer shouldn't be playing here" + mediaPlayer.isPlaying());

                        } else {
                            Log.v("Adapter", "mediaPlayer shouldn't be playing here" + mediaPlayer.isPlaying());
                            mediaPlayer.start();
                            holder.play.setImageResource(R.drawable.pause);
                            Log.v("Adapter", "current pos == pos and !isPlaying");
                            Log.v("Adapter", "" + currentPosition);
                            Log.v("Adapter", "mediaPlayer should be playing here" + mediaPlayer.isPlaying());
                        }
                    }
                }

            }
        });


        holder.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {

                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    holder.play.setImageResource(R.drawable.ic_play);

                }
            }

        });


        return convertView;


    }


}