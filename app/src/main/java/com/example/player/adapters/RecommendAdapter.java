package com.example.player.adapters;


import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.player.R;
import com.example.player.activities.PlayerActivity;
import com.example.player.fragments_pages.AllMusicFiles;
import com.example.player.holders.RecommendViewHolder;

import java.io.IOException;
import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendViewHolder> {

    private final List<AllMusicFiles> recommendItems;

    Context context;


    public RecommendAdapter(List<AllMusicFiles> recommendItems, Context context) {
        this.recommendItems = recommendItems;
        this.context = context;
    }



    @NonNull
    @Override
    public RecommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_item, parent, false);
        return new RecommendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendViewHolder holder, int position) {

        final AllMusicFiles recommendItem = recommendItems.get(position);

        holder.player_song_name.setText(recommendItem.getSongName());
        holder.player_artist_name.setText(recommendItem.getArtistName());

       holder.itemView.setOnClickListener(v -> {

         Intent intent = new Intent(context,PlayerActivity.class );
         intent.putExtra("position",position);
         intent.putExtra("All","recommend");
         context.startActivity(intent);


       });

       byte[] image = getAlbumArt(recommendItem.getPath());


        if (image!=null){

            Glide.with(context).load(image).into(holder.song_image);
        }else {

            Glide.with(context).load(R.drawable.img_8).into(holder.song_image);
        }


    }

    @Override
    public int getItemCount() {
        return recommendItems.size();
    }


    private byte[] getAlbumArt(String uri){

            MediaMetadataRetriever retriever = new MediaMetadataRetriever();


            retriever.setDataSource(uri);
            byte [] data = retriever.getEmbeddedPicture();

            try {
                retriever.release();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return data;


    }


}

