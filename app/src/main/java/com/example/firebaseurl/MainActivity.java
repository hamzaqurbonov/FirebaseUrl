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


//    ArrayList<Model> arrayList = new ArrayList<>();
//    ListView MylistView1;
    public static ArrayList<String> myArrayList1 = new ArrayList<>();
    DatabaseReference myRef;

    Model modelUrl ;

//    TextView VideoIds;
    private YouTubePlayerView youTubePlayerView;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        youTubePlayerView = findViewById(R.id.youtube_player_view);
//        initYouTubePlayerView();
//        VideoIds = findViewById(R.id.myRef1);


       final ArrayAdapter<String> myArrayAdaptrer = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,myArrayList1);
//        MylistView1 = (ListView) findViewById(R.id.listView1);
//        MylistView1.setAdapter(myArrayAdaptrer);
        myRef = FirebaseDatabase.getInstance().getReference();

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String value =  snapshot.getValue(String.class);
//                myArrayList1.add(value);
                myArrayAdaptrer.notifyDataSetChanged();
//                Log.d("demo16", myArrayList.get(0));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                myArrayAdaptrer.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        arrayList.add(new Model("android.resource://"+ getPackageName() + "/" + R.raw.b));
        arrayList.add(new Model("android.resource://"+ getPackageName() + "/" + R.raw.a3));

        adapter = new Adapter(MainActivity.this,arrayList);
        binding.viewpager2.setAdapter(adapter);

    }

    public void initYouTubePlayerView() {
        getLifecycle().addObserver(youTubePlayerView);

        YouTubePlayerListener listener = new AbstractYouTubePlayerListener() {

            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                setPlayNextVideoButtonClickListener(youTubePlayer);
                YouTubePlayerUtils.loadOrCueVideo(
                        youTubePlayer,
                        getLifecycle(),
                        "K7QHzcgvfck"
                        ,
                        0f

                );
//                Log.d("demo15", modelUrl.getVideoUrl());
            }

        };

        // disable web ui
        IFramePlayerOptions options = new IFramePlayerOptions.Builder().controls(0).build();

        youTubePlayerView.initialize(listener, options);
    }
//    @Override
//    public void onConfigurationChanged(@NonNull Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//        // Checks the orientation of the screen
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            youTubePlayerView.matchParent();
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            youTubePlayerView.wrapContent();
//        }
//    }
//    private void setPlayNextVideoButtonClickListener(final YouTubePlayer youTubePlayer) {
//        Button playNextVideoButton = findViewById(R.id.next_video_button);
//
//        playNextVideoButton.setOnClickListener(view ->
//                YouTubePlayerUtils.loadOrCueVideo(
//                        youTubePlayer,
//                        getLifecycle(),
//                        modelUrl.getNextVideoId(),
//
//                        0f
//                )
//        );
//    }
}