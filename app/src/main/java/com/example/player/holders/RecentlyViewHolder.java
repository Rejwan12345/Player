package com.example.player.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;

public class RecentlyViewHolder extends RecyclerView.ViewHolder {

    ShapeableImageView item_imageView;
    float radius = 10f;

    public RecentlyViewHolder(@NonNull View itemView) {
        super(itemView);

       item_imageView =   itemView.findViewById(R.id.item_imageView);

        ShapeAppearanceModel shapeAppearanceModel1 = ShapeAppearanceModel.builder()
                .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
                .setBottomRightCorner(CornerFamily.ROUNDED, radius)
                .setTopRightCorner(CornerFamily.ROUNDED, radius)
                .build();
        item_imageView.setShapeAppearanceModel(shapeAppearanceModel1);

    }
}
