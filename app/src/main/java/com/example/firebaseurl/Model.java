package com.example.firebaseurl;

import static com.example.firebaseurl.MainActivity.myArrayList;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Model {

    public static final Random random = new Random();
    public static String getNextVideoId() {
        int randomNext = random.nextInt(7) ;
        Log.d("demo19", String.valueOf(randomNext));
        Log.d("demo19", myArrayList.get(randomNext));
        return myArrayList.get(randomNext);
    }

    String videoUrl;

    public Model() {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        String videoUrl = getNextVideoId();
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
