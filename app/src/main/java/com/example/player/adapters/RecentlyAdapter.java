package com.example.player.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player.R;
import com.example.player.fragments_pages.AllMusicFiles;
import com.example.player.holders.RecentlyViewHolder;

import java.util.List;

public class RecentlyAdapter extends RecyclerView.Adapter<RecentlyViewHolder> {

    private final List<AllMusicFiles> recentlyItems;

    Context context;


    public RecentlyAdapter(List<AllMusicFiles> recentlyItems, Context context) {
        this.recentlyItems = recentlyItems;
        this.context = context;
    }




    @NonNull
    @Override
    public RecentlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music,parent,false);

        return new RecentlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }



}
