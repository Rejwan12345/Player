package com.example.player.fragments_pages;




import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player.R;
import com.example.player.adapters.AllSongsAdapter;

import java.util.ArrayList;
import java.util.List;


public class AllSongs extends Fragment {



    RecyclerView all_songs_recycler;

    AllSongsAdapter allSongsAdapter;

   public static List<AllMusicFiles> allMusicFiles = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_songs, container, false);



        all_songs_recycler = view.findViewById(R.id.all_songs_recycler);


        allSongsAdapter = new AllSongsAdapter(getContext(), allMusicFiles);
        all_songs_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        all_songs_recycler.setHasFixedSize(true);
        all_songs_recycler.setAdapter(allSongsAdapter);
        getAllAudioFiles();






        return view;
    }


    @SuppressLint("NotifyDataSetChanged")
    private void getAllAudioFiles() {
        ContentResolver contentResolver = requireContext().getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {

                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA ,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media._ID
        };

        Cursor cursor = contentResolver.query(uri, projection, null, null, null);

        if (cursor != null) {

            while (cursor.moveToNext()) {
                String song_album = cursor.getString(0);
                String song_name = cursor.getString(1);
                String song_duration = cursor.getString(2);
                String song_path = cursor.getString(3);
                String song_artist = cursor.getString(4);
                String song_id = cursor.getString(5);

                allMusicFiles.add(new AllMusicFiles(song_path , song_name , song_album , song_artist , song_duration , song_id) );
            }
            cursor.close();
        }

       allSongsAdapter.notifyDataSetChanged();

    }




}