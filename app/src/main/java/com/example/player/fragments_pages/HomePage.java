package com.example.player.fragments_pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player.PermissionHandler;
import com.example.player.R;
import com.example.player.adapters.RecentlyAdapter;
import com.example.player.adapters.RecommendAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends Fragment {


   public static List<AllMusicFiles> recommanedItemList = new ArrayList<>();
    static List<AllMusicFiles> recentlyItemList = new ArrayList<>();

   public static RecommendAdapter recommendViewAdapter;
    RecentlyAdapter recentlyAdapter;
    RecyclerView recentlyPlayedRecycler,recommendRecycler;
    EditText search_music;

   public static boolean shuffleBoolean = false , repeatBoolean = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        search_music = view.findViewById(R.id.search_music);

        recentlyPlayedRecycler=view.findViewById(R.id.recently_played_recycler);
        recommendRecycler = view.findViewById(R.id.recommend_recycler);
        recommendViewAdapter = new RecommendAdapter(recommanedItemList,getContext());
        recentlyAdapter = new RecentlyAdapter(recentlyItemList , getContext() );



        // Set up LayoutManager to be horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recentlyPlayedRecycler.setLayoutManager(layoutManager);
        recentlyPlayedRecycler.setAdapter(recentlyAdapter);





        recommendRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recommendRecycler.setHasFixedSize(true);
        recommendRecycler.setAdapter(recommendViewAdapter);
        PermissionHandler mPermissionHandler = new PermissionHandler(getActivity());




        if (mPermissionHandler.checkStoragePermission()) {

          

        }else {
            mPermissionHandler.requestPermissions();

        }

        return view;


    }




}









