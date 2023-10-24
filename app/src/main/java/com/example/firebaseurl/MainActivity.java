package com.example.firebaseurl;

import static android.content.ContentValues.TAG;


import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.play.core.integrity.model.a;
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
//    private static String[] itemsList16;
//public static String yourNameVariable;

    public static ArrayList<Object> itemsList = new ArrayList<>();

//    public static final String[]  itemsList1 = {itemsList.toString()};




    private static final Random random = new Random();

    public static String getNextVideoId() {
        String[]  itemsList2 = {itemsList.toString()};
        Log.d("demo12", itemsList2.toString());

        return  itemsList2[random.nextInt(itemsList2.length)];
    }

//    String itemsList;
//    public String toString() {
//
//        return itemsList;
//    }
    TextView VideoIds;

    private YouTubePlayerView youTubePlayerView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        youTubePlayerView = findViewById(R.id.youtube_player_view);

        initYouTubePlayerView();

        VideoIds = findViewById(R.id.myRef1);


        readData(new FirebaseCallback() {

            @Override
            public void onCallback(ArrayList<Object> list) {

                Log.d("demo4", list.toString());

            }


        });

        getNextVideoId();

    }

    public void readData(FirebaseCallback firebaseCallback) {


        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference firebaseRootRef = firebaseDatabase.getReference();
        DatabaseReference itemsRef = firebaseRootRef.child("items");
//        ArrayList<Object> itemsList = new ArrayList<>();

        ValueEventListener valueEventListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String itemName = ds.child("itemName").getValue(String.class);
                    itemsList.add(itemName);

                }
                firebaseCallback.onCallback(itemsList);

                Log.d("demo13", itemsList.toString());

            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        };
       
        itemsRef.addListenerForSingleValueEvent(valueEventListener);

    }




    public interface FirebaseCallback {

        void onCallback(ArrayList<Object> list);

    }

    public void initYouTubePlayerView() {
        getLifecycle().addObserver(youTubePlayerView);

        YouTubePlayerListener listener = new AbstractYouTubePlayerListener() {

            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                setPlayNextVideoButtonClickListener(youTubePlayer);
                YouTubePlayerUtils.loadOrCueVideo(
                        youTubePlayer,
                        getLifecycle(),
                        getNextVideoId()
                        ,
                        0f

                );
                Log.d("demo14", getNextVideoId());
                Log.d("demo14", itemsList.toString());
            }

        };

        // disable web ui
        IFramePlayerOptions options = new IFramePlayerOptions.Builder().controls(0).build();

        youTubePlayerView.initialize(listener, options);
    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            youTubePlayerView.matchParent();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            youTubePlayerView.wrapContent();
        }
    }

    /**
     * Set a click listener on the "Play next video" button
     */
    private void setPlayNextVideoButtonClickListener(final YouTubePlayer youTubePlayer) {
        Button playNextVideoButton = findViewById(R.id.next_video_button);

        playNextVideoButton.setOnClickListener(view ->
                YouTubePlayerUtils.loadOrCueVideo(
                        youTubePlayer,
                        getLifecycle(),
                        "HXrETVPKWh0",

                        0f
                )
        );
    }
}