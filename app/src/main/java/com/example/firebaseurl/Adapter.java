package com.example.firebaseurl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebaseurl.databinding.ReelDesgnBinding;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;

import java.util.ArrayList;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.VideoHolder> {
    Context context;
    ArrayList<Model> modelArrayList1 = new ArrayList<>();
    ArrayList<Integer> namberGetItemCount = new ArrayList<Integer>();
    String  ItemCount ;
    public static int modelArrayList;


    public static final String[] my = {"4UbhF0uNpaM", "dcKut31hF9g"};
    public static final Random random = new Random();
    public static String getNextVideoId() {

        return my[random.nextInt(my.length)];
    }

    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList1 = modelArrayList;

//        Log.d("demo20", modelArrayList.toString());
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reel_desgn,parent,false);

        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
//        holder.binding.videoView.setVideoPath(modelArrayList.get(position).getVideoUrl());
//        ItemCount = "true";


            holder.binding.youtubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer)  {

                    String videoId = getNextVideoId();
                    youTubePlayer.loadVideo(videoId, 0);
                    Log.d("demo20", String.valueOf(1));
//
                }

            });

//        holder.binding.youtubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
//            @Override
//            public void onReady(@NonNull YouTubePlayer youTubePlayer)  {
//
//                String videoId = getNextVideoId();
//                youTubePlayer.cueVideo(videoId, 0);
//                Log.d("demo20", String.valueOf(2));
////
//            }
//
//        });

    }

    @Override
    public int getItemCount() {

        ItemCount = "true";
        namberGetItemCount.add(1);
//        Log.d("demo20", String.valueOf(namberGetItemCount.size()));
        return modelArrayList = 5;
    }
    public class VideoHolder extends RecyclerView.ViewHolder{
        ReelDesgnBinding binding;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            binding = ReelDesgnBinding.bind(itemView);
        }

    }


}
