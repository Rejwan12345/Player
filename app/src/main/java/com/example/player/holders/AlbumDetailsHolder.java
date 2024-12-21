package com.example.player.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player.R;
import com.google.android.material.imageview.ShapeableImageView;

public class AlbumDetailsHolder extends RecyclerView.ViewHolder{

    public ShapeableImageView song_image;

    ImageView three_dots;
    public TextView player_song_name , player_artist_name;

    public AlbumDetailsHolder(@NonNull View itemView) {
        super(itemView);

        song_image = itemView.findViewById(R.id.song_image);
        player_song_name = itemView.findViewById(R.id.player_song_name);
        player_artist_name = itemView.findViewById(R.id.player_artist_name);
        three_dots = itemView.findViewById(R.id.three_dots);
    }
}
