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
    private int currentPosition;
    private ArrayList arrayList;
    private MediaPlayer mediaPlayer;
    private ImageView currentPlayingButton;
    private boolean isPlaying;

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
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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
        if (currentPosition != position) {
            holder.play.setImageResource(R.drawable.ic_play);
        } else {
            if (isPlaying) {
                holder.play.setImageResource(R.drawable.pause);
            } else {
                holder.play.setImageResource(R.drawable.ic_play);
            }
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
                    isPlaying = true;
                } else {
                    if (currentPosition != position) {
                        mediaPlayer.reset();
                        mediaPlayer.release();
                        currentPlayingButton.setImageResource(R.drawable.ic_play);
                        currentPlayingButton = holder.play;

                        mediaPlayer = MediaPlayer.create(context, music.getSong());
                        mediaPlayer.start();
                        isPlaying = true;
                        holder.play.setImageResource(R.drawable.pause);
                        currentPosition = position;
                    } else {
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.pause();
                            isPlaying = false;
                            holder.play.setImageResource(R.drawable.ic_play);
                        } else {
                            mediaPlayer.start();
                            isPlaying = true;
                            holder.play.setImageResource(R.drawable.pause);
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
                    isPlaying = false;
                }
            }
        });
        return convertView;
    }
}