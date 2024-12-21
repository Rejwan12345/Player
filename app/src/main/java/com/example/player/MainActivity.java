package com.example.player;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.player.fragments_pages.AllSongs;
import com.example.player.fragments_pages.FavPage;
import com.example.player.fragments_pages.HomePage;
import com.example.player.fragments_pages.AlbumPage;

public class MainActivity extends AppCompatActivity {


   static ImageView home , music , favourite , album ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home = findViewById(R.id.home);
        music = findViewById(R.id.music);
        favourite= findViewById(R.id.favourite);
        album = findViewById(R.id.album);


        home.setImageResource(R.drawable.home_selected);
        FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction().add(R.id.frame,new HomePage());
        fragmentManager.commit();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                home.setImageResource(R.drawable.home_selected);
                music.setImageResource(R.drawable.song_list);
                album.setImageResource(R.drawable.album);
                favourite.setImageResource(R.drawable.favourite);
                FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction().add(R.id.frame,new HomePage());
                fragmentManager.commit();


            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                home.setImageResource(R.drawable.home);
                music.setImageResource(R.drawable.song_list_selected);
                album.setImageResource(R.drawable.album);
                favourite.setImageResource(R.drawable.favourite);
                FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction().add(R.id.frame,new AllSongs());
                fragmentManager.commit();


            }
        });

        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                home.setImageResource(R.drawable.home);
                music.setImageResource(R.drawable.song_list);
                album.setImageResource(R.drawable.album_selected);
                favourite.setImageResource(R.drawable.favourite);
                FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction().add(R.id.frame,new AlbumPage());
                fragmentManager.commit();

            }
        });


        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                home.setImageResource(R.drawable.home);
                music.setImageResource(R.drawable.song_list);
                album.setImageResource(R.drawable.album);
                favourite.setImageResource(R.drawable.fav_selected);
                FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction().add(R.id.frame,new FavPage());
                fragmentManager.commit();

            }
        });


    }
}