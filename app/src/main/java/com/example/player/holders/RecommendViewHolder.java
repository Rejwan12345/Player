package com.example.player.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;

public class RecommendViewHolder extends RecyclerView.ViewHolder {

    public TextView player_song_name;
    public TextView player_artist_name;
    public ShapeableImageView song_image;
    float radius = 10f;



    public RecommendViewHolder(@NonNull View itemView) {
        super(itemView);

        player_song_name = itemView.findViewById(R.id.player_song_name);
        player_artist_name = itemView.findViewById(R.id.player_artist_name);
        song_image = itemView.findViewById(R.id.song_image);

        ShapeAppearanceModel shapeAppearanceModel = ShapeAppearanceModel.builder()
                .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
                .setBottomRightCorner(CornerFamily.ROUNDED, radius)
                .setTopRightCorner(CornerFamily.ROUNDED, radius)
                .build();
        song_image.setShapeAppearanceModel(shapeAppearanceModel);


    }
}
