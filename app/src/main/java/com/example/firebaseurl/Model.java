package com.example.firebaseurl;


import static com.example.firebaseurl.MainActivity.myArrayList1;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Model {

    public static final Random random = new Random();
    public static String getNextVideoId() {
        int randomNext = random.nextInt(7) ;
//        Log.d("demo19", String.valueOf(randomNext));
//        Log.d("demo19", myArrayList.get(randomNext));
        return myArrayList1.get(randomNext);
    }

    String videoUrl;

    String videoUrl2;

    //---------------------------------------------------------------

    public Model(String videoUrl, String videoUrl2) {
        this.videoUrl = videoUrl;
        this.videoUrl2 = videoUrl2;

    }

    public String getVideoUrl() {
//        String videoUrl = getNextVideoId();
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

//-------------------------------------------------

    public String getVideoUrl2() {
        return videoUrl2;
    }

    public void setVideoUrl2(String videoUrl2) {
        this.videoUrl2 = videoUrl2;
    }

}
