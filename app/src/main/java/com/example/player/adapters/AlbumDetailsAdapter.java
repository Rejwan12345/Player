package com.example.player.adapters;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.player.R;
import com.example.player.fragments_pages.AllMusicFiles;
import com.example.player.holders.AlbumDetailsHolder;

import java.io.IOException;
import java.util.List;

public class AlbumDetailsAdapter extends RecyclerView.Adapter<AlbumDetailsHolder>{


    Context context;
    List <AllMusicFiles> allAlbumFiles;

    public AlbumDetailsAdapter(Context context, List<AllMusicFiles> allAlbumFiles) {
        this.context = context;
        this.allAlbumFiles = allAlbumFiles;
    }


    @NonNull
    @Override
    public AlbumDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.all_items, parent, false);
        return new AlbumDetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumDetailsHolder holder, int position) {

        holder.player_song_name.setText(allAlbumFiles.get(position).getSongName());
        holder.player_artist_name.setText(allAlbumFiles.get(position).getArtistName());

        byte[] image = getAlbumArt(allAlbumFiles.get(position).getPath());

        if (image!=null){

            Glide.with(context).load(image).into(holder.song_image);
        }else {
            Glide.with(context).load(R.drawable.img_8).into(holder.song_image);
        }






    }

    @Override
    public int getItemCount() {
        return allAlbumFiles.size();
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
