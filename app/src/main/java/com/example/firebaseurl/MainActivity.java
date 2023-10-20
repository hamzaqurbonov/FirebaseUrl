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

public class MainActivity extends AppCompatActivity {
//    private static String[] itemsList16;
public String yourNameVariable;
//    public static final String[] itemsList1 = {};
//    public static String[] itemsList2 = {};?
//    public  String[] itemsList ;
//     int[] itemsList;

//    int itemsList2, itemsList3, itemsList4 = 20;
//    int[] itemsList5 = new int[5] ;
//    itemsList5[3] = 23;
//    itemsList5[4] = 12;
//    int[] itemsList6 = new int[] {23, 34, 56};
//        public static String readData () {
//
//            return readData();
//        }

//    public  String getNextVideoI() {
//
//       readData(new FirebaseCallback() {
//            @Override
//            public void onCallback(ArrayList<Object> list) {
//                Log.d("demo8", list.toString() );
//            }
//
//        });
//
//    }

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

                Log.d("demo4", list.toString());

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

    public void readData(FirebaseCallback firebaseCallback) {


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
                    yourNameVariable = ds.child("itemName").getValue(String.class);
                    itemsList.add(itemName);

                }
                firebaseCallback.onCallback(itemsList);

//                sayHiToMe();
                Log.d("demo7", itemsList.toString());
                Log.d("demo10", yourNameVariable);

            }


            @Override
            public void onCancelled( DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        };
       
        itemsRef.addListenerForSingleValueEvent(valueEventListener);
        Log.d(TAG, "After attaching the listener");


    }

    public interface FirebaseCallback {
        void onCallback(ArrayList<Object> list);
    }
//    public void sayHiToMe() {
//        Log.d("demo9", yourNameVariable );
//    }

    public void initYouTubePlayerView() {



        getLifecycle().addObserver(youTubePlayerView);


        YouTubePlayerListener listener = new AbstractYouTubePlayerListener() {

            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {


                setPlayNextVideoButtonClickListener(youTubePlayer);


                YouTubePlayerUtils.loadOrCueVideo(
                        youTubePlayer,
                        getLifecycle(),
                        yourNameVariable
                        ,
                        0f
                );
                Log.d("demo5", yourNameVariable );
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