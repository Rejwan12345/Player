package com.example.player.fragments_pages;

import static com.example.player.fragments_pages.AllSongs.allMusicFiles;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player.R;
import com.example.player.adapters.AlbumAdapter;


public class AlbumPage extends Fragment {

    RecyclerView album_recycler;

    AlbumAdapter allAlbumAdapter;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_album_page, container, false);

        album_recycler = view.findViewById(R.id.album_recycler);


        allAlbumAdapter = new AlbumAdapter(getContext(),allMusicFiles);
        album_recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        album_recycler.setHasFixedSize(true);
        album_recycler.setAdapter(allAlbumAdapter);
        allAlbumAdapter.notifyDataSetChanged();

        //getAllAudioFiles();

        return view;
    }



}