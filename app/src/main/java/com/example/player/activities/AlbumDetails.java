package com.example.player.activities;



import static com.example.player.fragments_pages.AllSongs.allMusicFiles;

import android.annotation.SuppressLint;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.player.R;
import com.example.player.adapters.AlbumDetailsAdapter;
import com.example.player.fragments_pages.AllMusicFiles;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDetails extends AppCompatActivity {

    ShapeableImageView album_profile;
    float radius = 30f;

    RecyclerView album_item_recycler;

    String albumName = "" ;
    String path = "" ;

    int position = 0;

    List<AllMusicFiles> albumSongs = new ArrayList<>();

    AlbumDetailsAdapter albumDetailsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);
        album_profile = findViewById(R.id.album_profile);
        album_item_recycler = findViewById(R.id.album_list_recycler);

        albumName = getIntent().getStringExtra("album_name");
        path = getIntent().getStringExtra("image");
        position = getIntent().getIntExtra("position", 0);

        int j = 0;

        for (int i = 0; i < allMusicFiles.size(); i++) {

            if (albumName.equals(allMusicFiles.get(i).getAlbumName())){

                albumSongs.add(j, allMusicFiles.get(i));
                j++;
            }
        }


        byte[] image = getAlbumArt(albumSongs.get(position).getPath());

        if (image!=null){

            Glide.with(this).load(image).into(album_profile);

        }
        else {

            Glide.with(this).load(R.drawable.img_8).into(album_profile);
        }

        SHAPED_IMAGE_VIEW();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();

        if (!(albumSongs.size()<1)){



            albumDetailsAdapter = new AlbumDetailsAdapter(this, albumSongs);
            album_item_recycler.setAdapter(albumDetailsAdapter);
            album_item_recycler.setHasFixedSize(true);
            album_item_recycler.setLayoutManager(new LinearLayoutManager(this));
            albumDetailsAdapter.notifyDataSetChanged();


        }

    }



    public void SHAPED_IMAGE_VIEW(){

        ShapeAppearanceModel shapeAppearanceModel = ShapeAppearanceModel.builder()
                .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
                .setBottomRightCorner(CornerFamily.ROUNDED, radius)
                .setTopRightCorner(CornerFamily.ROUNDED, radius)
                .build();
        album_profile.setShapeAppearanceModel(shapeAppearanceModel);


    }

    private byte[] getAlbumArt(String  uri){

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