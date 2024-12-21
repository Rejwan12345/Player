package com.example.player.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player.R;

public class AlbumHolder extends RecyclerView.ViewHolder{

    public ImageView album_img;
    public TextView album_name;

    public AlbumHolder(@NonNull View itemView) {
        super(itemView);

        album_img = itemView.findViewById(R.id.album_img);
        album_name = itemView.findViewById(R.id.album_name);
    }
}
