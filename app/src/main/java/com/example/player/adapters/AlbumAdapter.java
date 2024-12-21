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
import com.example.player.activities.AlbumDetails;
import com.example.player.fragments_pages.AllMusicFiles;
import com.example.player.holders.AlbumHolder;

import java.io.IOException;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumHolder>{


    Context context;
    List <AllMusicFiles> allAlbumFiles;

    public AlbumAdapter(Context context, List<AllMusicFiles> allAlbumFiles) {
        this.context = context;
        this.allAlbumFiles = allAlbumFiles;
    }


    @NonNull
    @Override
    public AlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.album_items, parent, false);
        return new AlbumHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumHolder holder, int position) {

        holder.album_name.setText(allAlbumFiles.get(position).getAlbumName());

        byte[] image = getAlbumArt(allAlbumFiles.get(position).getPath());

        if (image!=null){

            Glide.with(context).load(image).into(holder.album_img);
        }else {
            Glide.with(context).load(R.drawable.img_8).into(holder.album_img);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent = new Intent(context, AlbumDetails.class);
                intent.putExtra("album_name", allAlbumFiles.get(position).getAlbumName());
                intent.putExtra("image", allAlbumFiles.get(position).getPath());
                intent.putExtra("position", position);
                context.startActivity(intent);


            }
        });




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
