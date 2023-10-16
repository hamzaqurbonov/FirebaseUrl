package com.example.firebaseurl;

import static android.content.ContentValues.TAG;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {
    private static final String[] itemsList1 = {"AcT0Xrtg2tU"};
//    private static final String[] VideoIds3 = itemsList;

    public static String getNextVideoId() {
        return itemsList1[0];
    }

    TextView VideoIds;

    private YouTubePlayerView youTubePlayerView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("demo", "onCreate1" );

        youTubePlayerView = findViewById(R.id.youtube_player_view);

        initYouTubePlayerView();

        VideoIds = findViewById(R.id.myRef1);



        readData(new FirebaseCallback() {
            @Override
            public void onCallback(ArrayList<Object> list) {

                Log.d("demo1", list.toString());
            }
        });


//        childrefrence.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
//                String m = datasnapshot.getValue(String.class);
//
//                VideoIds.setText(m);
//
////                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
////                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
    }

    private void readData(FirebaseCallback firebaseCallback) {

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference firebaseRootRef = firebaseDatabase.getReference();
        DatabaseReference itemsRef = firebaseRootRef.child("items");
        ArrayList<Object> itemsList = new ArrayList<>();

        Log.d(TAG, "Before attaching the listener");
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, "inside onDataChange() method");

                
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String itemName = ds.child("itemName").getValue(String.class);
                    itemsList.add(itemName);
                }


                firebaseCallback.onCallback(itemsList);
//                Log.d("demo1", itemsList.toString());
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        };
       
        itemsRef.addListenerForSingleValueEvent(valueEventListener);
        Log.d(TAG, "After attaching the listener");
    }

    private interface FirebaseCallback {
        void onCallback(ArrayList<Object> list);
    }



//    private VideoIdsProvider2  {
//        private static final String[] VideoIds2 = {"iz8DQnO1ab4"};

//        private static final String[] liveVideoIds = {""};
//        private static final Random random = new Random();

//        public static String getNextVideoId() {
//            return VideoIds[0];
//        }
//
//        public static String getNextLiveVideoId() {
//            return liveVideoIds[random.nextInt(liveVideoIds.length)];
//        }
//    }


    private void initYouTubePlayerView() {
        getLifecycle().addObserver(youTubePlayerView);


        YouTubePlayerListener listener = new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                // using pre-made custom ui
//                    DefaultPlayerUiController defaultPlayerUiController = new DefaultPlayerUiController(youTubePlayerView, youTubePlayer);
//                    youTubePlayerView.setCustomPlayerUi(defaultPlayerUiController.getRootView());

                setPlayNextVideoButtonClickListener(youTubePlayer);


                YouTubePlayerUtils.loadOrCueVideo(
                        youTubePlayer,
                        getLifecycle(),
                        getNextVideoId(),
                        0f
                );
                Log.d("demo1", getNextVideoId());
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