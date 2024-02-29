package com.example.firebaseurl;

import static android.content.ContentValues.TAG;


import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.firebaseurl.databinding.ActivityMainBinding;
import com.google.android.play.core.integrity.model.a;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Model> arrayList = new ArrayList<>();
    
    Adapter adapter;



    public static ArrayList<String> myArrayList1 = new ArrayList<>();

    private YouTubePlayerView youTubePlayerView;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());


        setContentView(binding.getRoot());

        arrayList.add(new Model());

        adapter = new Adapter(MainActivity.this,arrayList);
        binding.viewpager2.setAdapter(adapter);


//        initYouTubePlayerView();
    }

//    public void initYouTubePlayerView() {
//        getLifecycle().addObserver(youTubePlayerView);
//
//        YouTubePlayerListener listener = new AbstractYouTubePlayerListener() {
//
//            @Override
//            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//
//                YouTubePlayerUtils.loadOrCueVideo(
//                        youTubePlayer,
//                        getLifecycle(),
//                        "K7QHzcgvfck"
//                        ,
//                        0f
//                );
//
//            }
//
//        };
//
//        // disable web ui
//        IFramePlayerOptions options = new IFramePlayerOptions.Builder().controls(0).build();
//
//        youTubePlayerView.initialize(listener, options);
//    }

}