package com.example.player.fragments_pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;

import java.util.ArrayList;
import java.util.HashMap;


public class FavPage extends Fragment {


    HashMap<String,String> hashMap = new HashMap<>();
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();

    RecyclerView fav_album_recycler,fav_music_recycler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fav_page, container, false);

        fav_album_recycler=view.findViewById(R.id.fav_album_recycler);
        fav_music_recycler= view.findViewById(R.id.fav_music_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        fav_album_recycler.setLayoutManager(layoutManager);
        fav_album_recycler.setAdapter(new FavouriteAlbumViewAdapter());

        int numberOfColumns = 3; // Define the number of columns for the grid
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), numberOfColumns);
        fav_music_recycler.setLayoutManager(gridLayoutManager);
        fav_music_recycler.setAdapter(new FavouriteMusicViewAdapter());

        return view;

    }

    public class FavouriteAlbumViewAdapter extends RecyclerView.Adapter<FavouriteAlbumViewAdapter.myViewHolder> {


        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = getLayoutInflater();

            View view = layoutInflater.inflate(R.layout.fav_album,parent,false);

            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class myViewHolder extends RecyclerView.ViewHolder{

            ShapeableImageView fav_album;
            float radius = 10f; // Adjust as needed


            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                fav_album = itemView.findViewById(R.id.fav_album);

                ShapeAppearanceModel shapeAppearanceModel = ShapeAppearanceModel.builder()
                        .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                        .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
                        .setBottomRightCorner(CornerFamily.ROUNDED, radius)
                        .setTopRightCorner(CornerFamily.ROUNDED, radius)
                        .build();
                fav_album.setShapeAppearanceModel(shapeAppearanceModel);

            }
        }

    }
    public class FavouriteMusicViewAdapter extends RecyclerView.Adapter<FavouriteMusicViewAdapter.myViewHolder> {


        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = getLayoutInflater();

            View view = layoutInflater.inflate(R.layout.fav_music,parent,false);

            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {




        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class myViewHolder extends RecyclerView.ViewHolder{

            ShapeableImageView fav_music;

            float radius = 10f; // Adjust as needed


            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                fav_music = itemView.findViewById(R.id.fav_music);

                ShapeAppearanceModel shapeAppearanceModel = ShapeAppearanceModel.builder()
                        .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                        .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
                        .setBottomRightCorner(CornerFamily.ROUNDED, radius)
                        .setTopRightCorner(CornerFamily.ROUNDED, radius)
                        .build();
                fav_music.setShapeAppearanceModel(shapeAppearanceModel);

            }
        }

    }
}